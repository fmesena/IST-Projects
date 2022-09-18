package com.forkexec.hub.ws;

import java.sql.SQLOutput;
import java.util.*;

import javax.jws.WebService;

import com.forkexec.hub.domain.*;
import com.forkexec.pts.ws.cli.exception.EmailAlreadyExistsFaultException;
import com.forkexec.pts.ws.cli.exception.InvalidEmailFaultException;
import com.forkexec.pts.ws.cli.exception.InvalidPointsFaultException;
import com.forkexec.pts.ws.cli.exception.NotEnoughBalanceFaultException;
import com.forkexec.rst.ws.cli.*;
import com.forkexec.rst.ws.*;
import com.forkexec.pts.ws.cli.*;
import com.forkexec.pts.ws.*;
import com.forkexec.cc.ws.cli.*;
import pt.ulisboa.tecnico.sdis.ws.uddi.*;

/**
 * This class implements the Web Service port type (interface). The annotations
 * below "map" the Java class to the WSDL definitions.
 */
@SuppressWarnings("MagicConstant")
@WebService(endpointInterface = "com.forkexec.hub.ws.HubPortType",
            wsdlLocation = "HubService.wsdl",
            name ="HubWebService",
            portName = "HubPort",
            targetNamespace="http://ws.hub.forkexec.com/",
            serviceName = "HubService"
)
public class HubPortImpl implements HubPortType {

	/**
	 * The Endpoint manager controls the Web Service instance during its whole
	 * lifecycle.
	 */
	private HubEndpointManager endpointManager;
	private static final int COPIES = 3;
	private static final FrontEnd frontEnd = FrontEnd.getInstance();

	/** Constructor receives a reference to the endpoint manager. */
	public HubPortImpl(HubEndpointManager endpointManager) {
		this.endpointManager = endpointManager;
	}
	
	// Main operations -------------------------------------------------------
	
	@Override
	public void activateAccount(String userId) throws InvalidUserIdFault_Exception {

		try {
			//String url = endpointManager.getUddiNaming().lookup("A51_Points");

			// Create a new points client
			//PointsClient pointsClient = new PointsClient(url);
			// Registry on Points server

			frontEnd.init(endpointManager.getUddiNaming().getUDDIUrl(), COPIES);

			frontEnd.activateUser(userId);

			// Registry on cart
			Hub.getInstance().addToCart(userId, new HubFoodOrder(Hub.getInstance().getOrderNum(), new ArrayList<>()));

			Hub.getInstance().incrOrderNum();

		} catch (EmailAlreadyExistsFaultException e) {
			throwInvalidUserIdFault("Email already exists");
		} catch (InvalidEmailFaultException e) {
			throwInvalidUserIdFault("Invalid user identifier!");
		}
	}


	@Override
	public void loadAccount(String userId, int moneyToAdd, String creditCardNumber)
			throws InvalidCreditCardFault_Exception, InvalidMoneyFault_Exception, InvalidUserIdFault_Exception {

		try {
			//String url = endpointManager.getUddiNaming().lookup("A51_Points");

			// Create a new points client
			//PointsClient pointsClient = new PointsClient(url);
            frontEnd.init(endpointManager.getUddiNaming().getUDDIUrl(), COPIES);

			// Check credit card number
			CreditCardClient ccClient = new CreditCardClient("http://ws.sd.rnl.tecnico.ulisboa.pt:8080/cc");
            if (!ccClient.validateNumber(creditCardNumber))
                throwInvalidCreditCardFault();

			// Convert Euros to pontos-comes
			int points = Hub.getInstance().getPontosComes(moneyToAdd);
			if (points == -1)
				throwInvalidMoneyFault("Invalid money! Check the conversion table.");

			// Add pontos-comes to user
			frontEnd.addPoints(userId, points);

		}catch (InvalidPointsFaultException e) {
			throwInvalidMoneyFault(e.getMessage());
        } catch (InvalidEmailFaultException e) {
			throwInvalidUserIdFault(e.getMessage());
        }
    }


	@Override
	public List<Food> searchDeal(String description) throws InvalidTextFault_Exception {
		List<Food> foods = new ArrayList<Food>();

		try {
			// Search food
			foods = searchFoods(description);

			// Order foods by lowest price
			Collections.sort(foods, new PriceComparator());

		} catch (UDDINamingException e) {
			System.out.printf("Caught exception when listing: %s%n", e);
			throw new RuntimeException(e);
		} catch (RestaurantClientException e) {
			System.out.printf("Caught exception when creating a new Restaurant Client: %s%n", e);
			throw new RuntimeException(e);
		} catch (BadTextFault_Exception e) {
			throwInvalidTextFault(e.getMessage());
		}

		return foods;
	}

	@Override
	public List<Food> searchHungry(String description) throws InvalidTextFault_Exception {
		List<Food> foods = new ArrayList<Food>();

		try {
			// Search food
			foods = searchFoods(description);

			// Order foods by lowest price
			Collections.sort(foods, new PreparationTimeComparator());

		} catch (UDDINamingException e) {
			System.out.printf("Caught exception when listing: %s%n", e);
			throw new RuntimeException(e);
		} catch (RestaurantClientException e) {
			System.out.printf("Caught exception when creating a new Restaurant Client: %s%n", e);
			throw new RuntimeException(e);
		} catch (BadTextFault_Exception e) {
			throwInvalidTextFault(e.getMessage());
		}

		return foods;
	}

	@Override
	public void addFoodToCart(String userId, FoodId foodId, int foodQuantity)
			throws InvalidFoodIdFault_Exception, InvalidFoodQuantityFault_Exception, InvalidUserIdFault_Exception {

		if (userId == null)
			throwInvalidUserIdFault("User email can not be null!");

		if (!Hub.getInstance().isRegistered(userId))
			throwInvalidUserIdFault("User email does not exist. First, activate an account.");

		if (foodQuantity <= 0)
			throwInvalidFoodQuantity("Quantity must be a positive integer!");

		if (foodId.getMenuId() == null)
			throwInvalidFoodIdFault("Bad food to add to cart. Menu identifier must be a positive integer.");

		if (foodId.getRestaurantId() == null)
			throwInvalidFoodIdFault("Bad food to add to cart. Restaurant identifier must be a positive integer.");

		Hub hub = Hub.getInstance();

		HubFoodOrderItem foodOrd = new HubFoodOrderItem(foodId.getMenuId(), foodId.getRestaurantId(), foodQuantity);
		if (hub.getFoodOrder(userId) == null) {
			// Create FoodOrderItem with respect to foodId then add it to the HubFoodOrderItem List
			ArrayList<HubFoodOrderItem> foodOrdList = new ArrayList<>();
			foodOrdList.add(foodOrd);

			// Finally, add it to the userId cart
			hub.addToCart(userId, new HubFoodOrder(hub.getOrderNum(), foodOrdList));
		}
		// The client with specified userId already has orders
		else {
			HubFoodOrder userIdOrders = hub.getFoodOrder(userId);
			userIdOrders.addFoodOrderItems(foodOrd);
			hub.addToCart(userId, userIdOrders);
		}

	}


	@Override
	public void clearCart(String userId) throws InvalidUserIdFault_Exception {
		if (userId == null)
			throwInvalidUserIdFault("User email can not be null!");

		if (!Hub.getInstance().isRegistered(userId))
			throwInvalidUserIdFault("User email does not exist. First, activate an account.");

		Hub.getInstance().clearCart(userId);
	}

	@Override
	public FoodOrder orderCart(String userId)
			throws EmptyCartFault_Exception, InvalidUserIdFault_Exception, NotEnoughPointsFault_Exception, InvalidFoodQuantityFault_Exception {

		HubFoodOrder userOrder = null;
		Hub hub = Hub.getInstance();

		if (!hub.isRegistered(userId))
			throwInvalidUserIdFault("User is not registered yet.");
		if (hub.getFoodOrder(userId).getFoodOrderItems().size() == 0)
			throwEmptyCartFault();

		try {

			//String url = endpointManager.getUddiNaming().lookup("A51_Points");
			//PointsClient pointsClient = new PointsClient(url);
            frontEnd.init(endpointManager.getUddiNaming().getUDDIUrl(), COPIES);

			userOrder = hub.getFoodOrder(userId);

			String restaurantId;
			String menuId;
			int    quantity;
			int    toSpend = 0;

			// For each ordered FoodItem by the user
			for (HubFoodOrderItem orderItem : userOrder.getFoodOrderItems()) {
				// Check HubFoodOrderItem fields
				restaurantId   = orderItem.getRestaurantId();
				menuId 	 	   = orderItem.getMenuId();

				// Search for the respective restaurant
				String url = endpointManager.getUddiNaming().lookup(restaurantId);
				RestaurantClient restaurantClient = new RestaurantClient(url);

				MenuId mId = buildMenuIdView(menuId);
				Menu menu  =  restaurantClient.getMenu(mId);

				// Accumulate the user's orders price
				toSpend += menu.getPrice();
			}

			// Spend points. Implicitly checks if the user has enough points
			frontEnd.spendPoints(userId, toSpend);

			// Order all the menus
			for (HubFoodOrderItem orderItem : userOrder.getFoodOrderItems()) {
				// Check HubFoodOrderItem fields
				restaurantId   = orderItem.getRestaurantId();
				menuId 	 	   = orderItem.getMenuId();
				quantity 	   = orderItem.getFoodQuantity();

				// Search for the respective restaurant
				String url = endpointManager.getUddiNaming().lookup(restaurantId);
				RestaurantClient restaurantClient = new RestaurantClient(url);

				restaurantClient.orderMenu(buildMenuIdView(menuId), quantity);
			}

		} catch (UDDINamingException e) {
			System.out.printf("Caught exception when listing: %s%n", e);
			throw new RuntimeException(e);
		} catch (RestaurantClientException e) {
			System.out.printf("Caught exception when creating a new Restaurant Client: %s%n", e);
			throw new RuntimeException(e);
		}catch (InsufficientQuantityFault_Exception e) {
			throwInvalidFoodQuantity(e.getMessage());
		} catch (BadQuantityFault_Exception e) {
			throwInvalidFoodQuantityFault(e.getMessage());
		} catch (BadMenuIdFault_Exception e) {
			// RuntimeException is thrown because there is no other proper exception in HubPortImpl to handle BadMenuIdFault_Exception
			System.out.println("No such menu id.");
			throw new RuntimeException(e);
		} catch (InvalidPointsFaultException e) {
			throwNotEnoughPointsFault(e.getMessage());
        } catch (InvalidEmailFaultException e) {
			throwInvalidUserIdFault(e.getMessage());
        } catch (NotEnoughBalanceFaultException e) {
			throwNotEnoughPointsFault(e.getMessage());
        }

        return buildFoodOrderView(userOrder);
	}



	@Override
	public int accountBalance(String userId) throws InvalidUserIdFault_Exception {
		int balance = 0;

		try {
			//String url = endpointManager.getUddiNaming().lookup("A51_Points");

			// Create a new points client
			//PointsClient client = new PointsClient(url);
            frontEnd.init(endpointManager.getUddiNaming().getUDDIUrl(), COPIES);
			balance = frontEnd.pointsBalance(userId);

		}catch (InvalidEmailFaultException e) {
			throwInvalidUserIdFault(e.getMessage());
		}

        return balance;
	}

	@Override
	public Food getFood(FoodId foodId) throws InvalidFoodIdFault_Exception {
		Food food = null;
		String restaurantId = foodId.getRestaurantId();
		String id = foodId.getMenuId();
		MenuId menuId = new MenuId();
		menuId.setId(id);

		try {
			String url = endpointManager.getUddiNaming().lookup(restaurantId);

			// Create a new restaurant client
			RestaurantClient client = new RestaurantClient(url);

			Menu menu = client.getMenu(menuId);
			food = buildFoodView(buildHubFood(menu, restaurantId));


		} catch (UDDINamingException e) {
			System.out.printf("Caught exception when listing: %s%n", e);
			throw new RuntimeException(e);
		} catch (RestaurantClientException e) {
			System.out.printf("Caught exception when creating a new Restaurant Client: %s%n", e);
			throw new RuntimeException(e);
		} catch (BadMenuIdFault_Exception e) {
			throwInvalidFoodIdFault(e.getMessage());
		}

		return food;
	}


	@Override
	public List<FoodOrderItem> cartContents(String userId) throws InvalidUserIdFault_Exception {

		if (userId == null)
			throwInvalidUserIdFault("User email can not be null!");

		if (!Hub.getInstance().isRegistered(userId))
			throwInvalidUserIdFault("User email does not exist. First, activate an account.");

		return buildFoodOrderItemView(Hub.getInstance().getFoodOrderItems(userId));
	}



	// Control operations ----------------------------------------------------
	/** Diagnostic operation to check if service is running. */
	@Override
	public String ctrlPing(String inputMessage) {
		// If no input is received, return a default name.
		if (inputMessage == null || inputMessage.trim().length() == 0)
			inputMessage = "friend";

		// If the service does not have a name, return a default.
		String wsName = endpointManager.getWsName();
		if (wsName == null || wsName.trim().length() == 0)
			wsName = "Hub";

		// Build a string with a message to return.
		StringBuilder builder = new StringBuilder();
		builder.append("Hello ").append(inputMessage);
		builder.append(" from ").append(wsName);

		// Ping all restaurants and build string to return.
		try {
			Collection<String> urls = endpointManager.getUddiNaming().list("A51_Restaurant%");

			for (String url: urls) {
				RestaurantClient client = new RestaurantClient(url);
				builder.append("\n").append(client.ctrlPing("hub"));
			}
		} catch (Exception e) {
			System.out.printf("Caught exception when listing: %s%n", e);
		}

		return builder.toString();
	}


	/** Return all variables to default values. */
	@Override
	public void ctrlClear() {
		// Clear hub
		Hub.getInstance().clear();

		try {
			// Clear Restaurants
			Collection<String> urls = endpointManager.getUddiNaming().list("A51_Restaurant%");

			// For each existing restaurant
			for (String url: urls) {

				// Create a new restaurant client
				RestaurantClient restaurantClient = new RestaurantClient(url);

				restaurantClient.ctrlClear();


			// Clear points
				//String pointsUrl = endpointManager.getUddiNaming().lookup("A51_Points");

				// Create a new points client
				//PointsClient pointsClient = new PointsClient(pointsUrl);
                frontEnd.init(endpointManager.getUddiNaming().getUDDIUrl(), COPIES);

				frontEnd.ctrlClear();
			}
		} catch (UDDINamingException e) {
			System.out.printf("Caught exception when listing: %s%n", e);
			throw new RuntimeException(e);
		} catch (RestaurantClientException e) {
			System.out.printf("Caught exception when creating a new Restaurant Client: %s%n", e);
			throw new RuntimeException(e);
		}

	}
	/** Set variables with specific values. */
	@Override
	public void ctrlInitFood(List<FoodInit> initialFoods) throws InvalidInitFault_Exception {
		try {
			for (FoodInit finit: initialFoods) {
				Food f = finit.getFood();
				int quantity = finit.getQuantity();

				FoodId fid = f.getId();
				String rid = fid.getRestaurantId();
				MenuId mid = buildMenuIdView(fid.getMenuId());

				String url = endpointManager.getUddiNaming().lookup(rid);

				// Create a new restaurant client
				RestaurantClient client = new RestaurantClient(url);

				Menu m = buildMenuView(mid, f.getEntree(), f.getPlate(), f.getDessert(),
											f.getPrice(), f.getPreparationTime());

				MenuInit minit = buildMenuInitView(m, quantity);

				// Build list
				List<MenuInit> minits = new ArrayList<>();
				minits.add(minit);

				// Send list to restaurant
				client.ctrlInit(minits);
			}
		} catch (UDDINamingException e) {
			System.out.printf("Caught exception when listing: %s%n", e);
			throw new RuntimeException(e);
		} catch (RestaurantClientException e) {
			System.out.printf("Caught exception when creating a new Restaurant Client: %s%n", e);
			throw new RuntimeException(e);
		} catch (com.forkexec.rst.ws.BadInitFault_Exception e) {
			throwInvalidInitFault(e.getMessage());
		}
	}

	@Override
	public void ctrlInitUserPoints(int startPoints) throws InvalidInitFault_Exception {
		if (startPoints < 0)
			throwInvalidInitFault("Bad init! Can not have negative points.");

		try {

			//String url = endpointManager.getUddiNaming().lookup("A51_Points");
			//PointsClient points = new PointsClient(url);
            frontEnd.init(endpointManager.getUddiNaming().getUDDIUrl(), COPIES);
			frontEnd.ctrlInit(startPoints);

		}catch (com.forkexec.pts.ws.BadInitFault_Exception e) {
			throwInvalidInitFault(e.getMessage());
		}
	}



	// Auxiliary operations --------------------------------------------------
	private HubFood buildHubFood(Menu menu, String restaurantId) {
		return new HubFood(restaurantId, menu.getId().getId(), menu.getEntree(), menu.getPlate(),
								menu.getDessert(), menu.getPrice(), menu.getPreparationTime());
	}

	private MenuInit buildMenuInitView(Menu menu, int quantity) {
		MenuInit view = new MenuInit();

		view.setMenu(menu);
		view.setQuantity(quantity);

		return view;
	}
	private Menu buildMenuView(MenuId id, String entree, String plate, String dessert, int price,
								int preparationTime) {
		Menu view = new Menu();

		view.setId(id);
		view.setEntree(entree);
		view.setPlate(plate);
		view.setDessert(dessert);
		view.setPrice(price);
		view.setPreparationTime(preparationTime);

		return view;
	}

	private MenuId buildMenuIdView(String id) {
		MenuId view = new MenuId();
		view.setId(id);

		return view;
	}

	private FoodOrder buildFoodOrderView(HubFoodOrder foodOrder) {
		FoodOrder view = new FoodOrder();
		FoodOrderId foi = new FoodOrderId();
		List<FoodOrderItem> items = buildFoodOrderItemView(foodOrder.getFoodOrderItems());

		foi.setId(foodOrder.getId());
		view.setFoodOrderId(foi);
		
		return view;
	}

	private List<FoodOrderItem> buildFoodOrderItemView(List<HubFoodOrderItem> foodOrderItems) {

		List<FoodOrderItem> view = new ArrayList<>();
		FoodId fId;
		FoodOrderItem orderItem;

		for (HubFoodOrderItem item : foodOrderItems) {
			fId = new FoodId();
			fId.setRestaurantId(item.getRestaurantId());
			fId.setMenuId(item.getMenuId());

			orderItem = new FoodOrderItem();
			orderItem.setFoodId(fId);
			orderItem.setFoodQuantity(item.getFoodQuantity());

			view.add(orderItem);
		}

		return view;
	}

	private List<Food> searchFoods(String description) throws UDDINamingException, BadTextFault_Exception, RestaurantClientException{
		List<Food> foods = new ArrayList<>();

		Collection<UDDIRecord> records = endpointManager.getUddiNaming().listRecords("A51_Restaurant%");

			// For each existing restaurant
			for (UDDIRecord record: records) {
				String restaurantId = record.getOrgName();
				String url = record.getUrl();

				// Create a new restaurant client
				RestaurantClient client = new RestaurantClient(url);

				List<Menu> menus = new ArrayList<Menu>();
				menus = client.searchMenus(description);

				for (Menu menu: menus) {
					Food food = buildFoodView(buildHubFood(menu, restaurantId));
					foods.add(food);
				}
			}

			return foods;
	}


	// View helpers ----------------------------------------------------------
	// /** Helper to convert a domain object to a view. */

	private Food buildFoodView(HubFood food) {
		Food view = new Food();
		FoodId foodId = new FoodId();

		foodId.setRestaurantId(food.getRestaurantId());
		foodId.setMenuId(food.getMenuId());

		view.setId(foodId);
		view.setEntree(food.getEntree());
		view.setPlate(food.getPlate());
		view.setDessert(food.getDessert());
		view.setPrice(food.getPrice());
		view.setPreparationTime(food.getPreparationTime());

		return view;
	}


	// Comparators ------------------------------------------------------------

	public class PriceComparator implements Comparator<Food> {

		@Override
		public int compare(Food f1, Food f2) {
			return f1.getPrice() - f2.getPrice();
		}

	}

	public class PreparationTimeComparator implements Comparator<Food> {
		@Override
		public int compare(Food f1, Food f2) {
			return f1.getPreparationTime() - f2.getPreparationTime();
		}

	}


	// Exception helpers -----------------------------------------------------

	private void throwInvalidFoodIdFault(final String message) throws InvalidFoodIdFault_Exception {
		final InvalidFoodIdFault faultInfo = new InvalidFoodIdFault();
		faultInfo.setMessage(message);
		throw new InvalidFoodIdFault_Exception(message, faultInfo);
	}
	private void throwInvalidTextFault(final String message) throws InvalidTextFault_Exception {
		final InvalidTextFault faultInfo = new InvalidTextFault();
		faultInfo.setMessage(message);
		throw new InvalidTextFault_Exception(message, faultInfo);
	}
	private void throwInvalidMoneyFault(final String message) throws InvalidMoneyFault_Exception {
		final InvalidMoneyFault faultInfo = new InvalidMoneyFault();
		faultInfo.setMessage(message);
		throw new InvalidMoneyFault_Exception(message, faultInfo);
	}

	private void throwInvalidUserIdFault(final String message) throws InvalidUserIdFault_Exception {
		final InvalidUserIdFault faultInfo = new InvalidUserIdFault();
		faultInfo.setMessage(message);
		throw new InvalidUserIdFault_Exception(message, faultInfo);
	}

	private void throwInvalidInitFault(final String message) throws InvalidInitFault_Exception {
		final InvalidInitFault faultInfo = new InvalidInitFault();
		faultInfo.setMessage(message);
		throw new InvalidInitFault_Exception(message, faultInfo);
	}

	private void throwInvalidCreditCardFault() throws InvalidCreditCardFault_Exception {
		final InvalidCreditCardFault faultInfo = new InvalidCreditCardFault();
		faultInfo.setMessage("Bad credit number!");
		throw new InvalidCreditCardFault_Exception("Bad credit number!", faultInfo);
	}

	private void throwInvalidFoodQuantity(final String message) throws InvalidFoodQuantityFault_Exception {
		final InvalidFoodQuantityFault faultInfo = new InvalidFoodQuantityFault();
		faultInfo.setMessage(message);
		throw new InvalidFoodQuantityFault_Exception(message, faultInfo);
	}

	private void throwEmptyCartFault() throws EmptyCartFault_Exception {
		final EmptyCartFault faultInfo = new EmptyCartFault();
		faultInfo.setMessage("Cart is empty!");
		throw new EmptyCartFault_Exception("Cart is empty!", faultInfo);
	}

	private void throwInvalidFoodQuantityFault(final String message) throws InvalidFoodQuantityFault_Exception {
		final InvalidFoodQuantityFault faultInfo = new InvalidFoodQuantityFault();
		faultInfo.setMessage(message);
		throw new InvalidFoodQuantityFault_Exception(message, faultInfo);
	}

	private void throwNotEnoughPointsFault(final String message) throws NotEnoughPointsFault_Exception {
		final NotEnoughPointsFault faultInfo = new NotEnoughPointsFault();
		faultInfo.setMessage(message);
		throw new NotEnoughPointsFault_Exception(message, faultInfo);
	}

}