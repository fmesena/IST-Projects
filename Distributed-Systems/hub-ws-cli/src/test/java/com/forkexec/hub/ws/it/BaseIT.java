package com.forkexec.hub.ws.it;

import java.io.IOException;
import java.util.Properties;
import java.util.ArrayList;
import java.util.List;

import com.forkexec.hub.ws.*;
import com.forkexec.hub.ws.cli.HubClient;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import org.junit.*;

/**
 * Base class for testing a Park Load properties from test.properties
 */
public class BaseIT {

	private static final String TEST_PROP_FILE = "/test.properties";
	protected static Properties testProps;

	protected static HubClient client;

	protected String email 		= "john.doe@service";
	protected FoodId foodId   	= new FoodId();

	@BeforeClass
	public static void oneTimeSetup() throws Exception {
		testProps = new Properties();
		try {
			testProps.load(BaseIT.class.getResourceAsStream(TEST_PROP_FILE));
			System.out.println("Loaded test properties:");
			System.out.println(testProps);
		} catch (IOException e) {
			final String msg = String.format("Could not load properties file {}", TEST_PROP_FILE);
			System.out.println(msg);
			throw e;
		}

		final String uddiEnabled = testProps.getProperty("uddi.enabled");
		final String verboseEnabled = testProps.getProperty("verbose.enabled");

		final String uddiURL = testProps.getProperty("uddi.url");
		final String wsName = testProps.getProperty("ws.name");
		final String wsURL = testProps.getProperty("ws.url");

		if ("true".equalsIgnoreCase(uddiEnabled)) {
			client = new HubClient(uddiURL, wsName);
		} else {
			client = new HubClient(wsURL);
		}
		client.setVerbose("true".equalsIgnoreCase(verboseEnabled));
	}

	@Before
	public void setup() throws InvalidInitFault_Exception, InvalidUserIdFault_Exception, InvalidFoodIdFault_Exception,
								InvalidFoodQuantityFault_Exception {
		foodId.setRestaurantId("A51_Restaurant1");
		foodId.setMenuId("1");

		// Register clients
		client.activateAccount(email);
		
		/*// Register foods
		List<FoodInit> finits = new ArrayList<>();

		FoodInit finit1 = createFoodInit("A51_Restaurant1", "1", "B_entree", "B_plate", "B_dessert", 50, 30, 100);
		FoodInit finit2 = createFoodInit("A51_Restaurant2", "2", "A_entree", "A_plate", "A_dessert", 10, 15, 100);

		finits.add(finit1);
		finits.add(finit2);

		client.ctrlInitFood(finits);

		// Register clients
		client.activateAccount(email);*/

		// Specific populates
		populate4Test();
	}

	@After
	public void tearDown() {
		client.ctrlClear();
	}

	@AfterClass
	public static void cleanup() {
		client.ctrlClear();
	}

	public void populate4Test() throws InvalidFoodIdFault_Exception, InvalidFoodQuantityFault_Exception,
										InvalidUserIdFault_Exception, InvalidInitFault_Exception {
	}

	protected FoodInit createFoodInit(String restaurantId, String menuId, String entree, String plate, 
									String dessert, int price, int prepTime, int quantity) {

		Food f 			= new Food();
		FoodInit finit 	= new FoodInit();
		FoodId fid   	= new FoodId();


		fid.setRestaurantId(restaurantId);
		fid.setMenuId(menuId);

		f.setId(fid);
		f.setEntree(entree);
		f.setPlate(plate);
		f.setDessert(dessert);
		f.setPrice(price);
		f.setPreparationTime(prepTime);

		finit.setFood(f);
		finit.setQuantity(quantity);

		return finit;
	}

}
