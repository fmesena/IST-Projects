package com.forkexec.rst.ws;

import java.util.List;
import java.util.ArrayList;

import javax.jws.WebService;

import com.forkexec.rst.domain.*;

/**
 * This class implements the Web Service port type (interface). The annotations
 * below "map" the Java class to the WSDL definitions.
 */
@WebService(endpointInterface = "com.forkexec.rst.ws.RestaurantPortType",
            wsdlLocation = "RestaurantService.wsdl",
            name ="RestaurantWebService",
            portName = "RestaurantPort",
            targetNamespace="http://ws.rst.forkexec.com/",
            serviceName = "RestaurantService"
)
public class RestaurantPortImpl implements RestaurantPortType {

	/**
	 * The Endpoint manager controls the Web Service instance during its whole
	 * lifecycle.
	 */
	private RestaurantEndpointManager endpointManager;

	/**
	 * Singletone restaurant instance.
	 */
	private final Restaurant restaurant = Restaurant.getInstance();

	/** Constructor receives a reference to the endpoint manager. */
	public RestaurantPortImpl(RestaurantEndpointManager endpointManager) {
		this.endpointManager = endpointManager;
	}


	
	// Main operations -------------------------------------------------------
	
	@Override
	public Menu getMenu(MenuId menuId) throws BadMenuIdFault_Exception {
		// Check menu id
		if (menuId == null)
			throwBadMenuIdFault("Menu identifier cannot be null!");
		if (restaurant.getMenu(menuId.getId()) == null)
			throwBadMenuIdFault("Menu identifier doesn't exist!");

		// Retrieve product
		String id = menuId.getId();
		RestaurantMenu menu = restaurant.getMenu(id);

		Menu view = buildMenuView(menu);

		// Return menu!
		return view;
	}
	
	@Override
	public List<Menu> searchMenus(String descriptionText) throws BadTextFault_Exception {
		// Check description text
		if (descriptionText == null)
			throwBadTextFault("Description text cannot be null!");
		if (descriptionText.contains(" "))
			throwBadTextFault("Description text cannot contain spaces!");
		if (descriptionText.length() == 0)
			throwBadTextFault("Description text cannot be empty!");

		List<Menu> menus = new ArrayList<Menu>();

		// Iterate over all menus
		for (RestaurantMenu menu: restaurant.getAllMenus()) {
			// Matching menu found!
			if (menu.isInDescription(descriptionText)) {
				Menu view = buildMenuView(menu);
				menus.add(view);
			}
		}

		// Return matching menus
		return menus;
	}

	@Override
	public MenuOrder orderMenu(MenuId arg0, int arg1)
			throws BadMenuIdFault_Exception, BadQuantityFault_Exception, InsufficientQuantityFault_Exception {
		if (arg0 == null)
			throwBadMenuIdFault("Menu identifier cannot be null!");			
		if (restaurant.getMenu(arg0.getId()) == null)
			throwBadMenuIdFault("Menu identifier doesn't exist!");
		if (arg1 <= 0)
			throwBadQuantityFault();
		if (!restaurant.hasEnough(arg0.getId(), arg1))
			throwInsufficientQuantityFault();
		
		// Valid order!
		String orderId = restaurant.orderMenu(arg0.getId(), arg1);
		MenuOrder order = buildMenuOrderView(orderId, arg0.getId(), arg1);
			
		return order;
	}

	

	// Control operations ----------------------------------------------------

	/** Diagnostic operation to check if service is running. */
	@Override
	public String ctrlPing(String inputMessage) {
		// If no input is received, return a default name
		if (inputMessage == null || inputMessage.trim().length() == 0)
			inputMessage = "friend";

		// If the park does not have a name, return a default
		String wsName = endpointManager.getWsName();
		if (wsName == null || wsName.trim().length() == 0)
			wsName = "Restaurant";

		// Build a string with a message to return
		StringBuilder builder = new StringBuilder();
		builder.append("Hello ").append(inputMessage);
		builder.append(" from ").append(wsName);
		return builder.toString();
	}

	/** Return all variables to default values. */
	@Override
	public void ctrlClear() {
		restaurant.clear();
	}

	/** Set variables with specific values. */
	@Override
	public void ctrlInit(List<MenuInit> initialMenus) throws BadInitFault_Exception {
		for (MenuInit newMenu: initialMenus) {
			RestaurantMenu menu = buildRestaurantMenu(newMenu);
			int quantity = newMenu.getQuantity();

			if (restaurant.getMenu(menu.getId()) != null)
				throwBadInitFault("Menu identifier already exists!");
			if (menu.getPrice() <= 0)
				throwBadInitFault("Menu price has to be a positive integer!");
			if (menu.getPreparationTime() < 0)
				throwBadInitFault("Menu preparation time cannot be a negative integer!");

			// Add new menu to the restaurant
			restaurant.addMenu(menu, quantity);
		}
	}



	// Auxiliary operations --------------------------------------------------

	private RestaurantMenu buildRestaurantMenu(MenuInit menuInit) {
		Menu menu = menuInit.getMenu();

		return new RestaurantMenu(menu.getId().getId(), menu.getEntree(), menu.getPlate(),
								menu.getDessert(), menu.getPrice(), menu.getPreparationTime());
	}



	// View helpers ----------------------------------------------------------

	private Menu buildMenuView(RestaurantMenu menu) {
		Menu view = new Menu();
		MenuId id = new MenuId();
		id.setId(menu.getId());

		view.setId(id);
		view.setEntree(menu.getEntree());
		view.setPlate(menu.getPlate());
		view.setDessert(menu.getDessert());
		view.setPrice(menu.getPrice());
		view.setPreparationTime(menu.getPreparationTime());

		return view;
	}

	private MenuOrder buildMenuOrderView(String orderId, String menuId, int quantity) {
		MenuOrderId id = new MenuOrderId();
		MenuId menu = new MenuId();
		MenuOrder order = new MenuOrder();

		id.setId(orderId);
		menu.setId(menuId);
		order.setId(id);
		order.setMenuId(menu);
		order.setMenuQuantity(quantity);

		return order;		
	}


	
	// Exception helpers -----------------------------------------------------

	/** Helper to throw a new BadInitFault exception. */
	private void throwBadInitFault(final String message) throws BadInitFault_Exception {
		BadInitFault faultInfo = new BadInitFault();
		faultInfo.message = message;
		throw new BadInitFault_Exception(message, faultInfo);
	}

	/** Helper method to throw new BadMenuIdFault exception */
	private void throwBadMenuIdFault(final String message) throws BadMenuIdFault_Exception {
		BadMenuIdFault faultInfo = new BadMenuIdFault();
		faultInfo.setMessage(message);
		throw new BadMenuIdFault_Exception(message, faultInfo);
	}

	/** Helper method to throw new BadTextFault exception */
	private void throwBadTextFault(final String message) throws BadTextFault_Exception {
		BadTextFault faultInfo = new BadTextFault();
		faultInfo.setMessage(message);
		throw new BadTextFault_Exception(message, faultInfo);
	}

	/** Helper method to throw new BadTextFault exception */
	private void throwBadQuantityFault() throws BadQuantityFault_Exception {
		BadQuantityFault faultInfo = new BadQuantityFault();
		faultInfo.setMessage("Quantity has to be a positive integer!");
		throw new BadQuantityFault_Exception("Quantity has to be a positive integer!", faultInfo);
	}

	/** Helper method to throw new BadTextFault exception */
	private void throwInsufficientQuantityFault() throws InsufficientQuantityFault_Exception {
		InsufficientQuantityFault faultInfo = new InsufficientQuantityFault();
		faultInfo.setMessage("There is not enough quantity!");
		throw new InsufficientQuantityFault_Exception("There is not enough quantity!", faultInfo);
	}

}
