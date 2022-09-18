package com.forkexec.rst.ws.it;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.forkexec.rst.ws.*;
import com.forkexec.rst.ws.cli.RestaurantClient;

import org.junit.*;

/**
 * Base class for testing a Park Load properties from test.properties
 */
public class BaseIT {

	private static final String TEST_PROP_FILE = "/test.properties";
	protected static Properties testProps;

	protected static RestaurantClient client;

	protected static final int NUM_MENUS = 500;
	protected final String id = "3";
	protected final String entree = "Marisco";
	protected final String plate = "Lasanha";
	protected final String dessert = "Gelado";
	protected final int price = 15;
	protected final int prepTime = 40;
	protected final int quantity = 100;
	protected List<MenuInit> menus = new ArrayList<>();


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
			client = new RestaurantClient(uddiURL, wsName);
		} else {
			client = new RestaurantClient(wsURL);
		}
		client.setVerbose("true".equalsIgnoreCase(verboseEnabled));
	}

	@Before
	public void setup() throws BadMenuIdFault_Exception, BadInitFault_Exception {
		menus = new ArrayList<>();
		menus.add(createMenuInit(id, entree, plate, dessert, price, prepTime, quantity));
		//menus.add(createMenuInit("Sistemas Distribuidos", "SOAP", "ForkExec", "REST", 100, 93, 1));
		client.ctrlInit(menus);
		menus = new ArrayList<>();
		populate4Test();
	}

	@After
	public void tearDown() {
		menus = new ArrayList<>();
		client.ctrlClear();
		
	}

	@AfterClass
	public static void cleanup() {
	}


	//abstract method -> abstract class...
	public void populate4Test() throws BadInitFault_Exception {
	}


	// help
	protected MenuInit createMenuInit(String _id, String _entree, String _plate, String _dessert,
									int _price, int _prepTime, int _quantity) {

		MenuInit _menu = new MenuInit();
		Menu _basicMenu = new Menu();
		MenuId _menuId = new MenuId();

		_menuId.setId(_id);

		_basicMenu.setId(_menuId);
		_basicMenu.setEntree(_entree);
		_basicMenu.setPlate(_plate);
		_basicMenu.setDessert(_dessert);
		_basicMenu.setPrice(_price);
		_basicMenu.setPreparationTime(_prepTime);

		_menu.setMenu(_basicMenu);
		_menu.setQuantity(_quantity);

		return _menu;
	}

	protected void assertEqualMenus(Menu menu1, Menu menu2) {
		Assert.assertEquals(menu1.getId().getId(), menu2.getId().getId());
		Assert.assertEquals(menu1.getEntree(), menu2.getEntree());
		Assert.assertEquals(menu1.getPlate(), menu2.getPlate());
		Assert.assertEquals(menu1.getDessert(), menu2.getDessert());
		Assert.assertEquals(menu1.getPrice(), menu2.getPrice());
		Assert.assertEquals(menu1.getPreparationTime(), menu2.getPreparationTime());
	}

	protected MenuId createMenuId(String id) {
		MenuId _menuId = new MenuId();
		_menuId.setId(id);
		return _menuId;
	}


}
