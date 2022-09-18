package com.forkexec.rst.domain;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Restaurant
 *
 * A restaurant server.
 *
 */
public class Restaurant {

	// Members ---------------------------------------------------------------

	/**
	 * Map of existing menus. Uses concurrent hash table implementation
	 * supporting full concurrency of retrievals and high expected concurrency
	 * for updates.
	 */
	private Map<String, RestaurantMenu> menus;

	/**
	 * Map of quantities of existing menus. Also uses concurrent hash table
	 * implementation.
	 */
	private Map<String, Integer> quantities;

	/**
	 * Global order identifier counter. Uses lock-free thread-safe single
	 * variable.
	 */
	private AtomicInteger orderIdCounter;

	// Singleton -------------------------------------------------------------

	/** Private constructor prevents instantiation from other classes. */
	private Restaurant() {
		menus = new ConcurrentHashMap<>();
		quantities = new ConcurrentHashMap<>();
		orderIdCounter = new AtomicInteger(0);
	}

	/**
	 * SingletonHolder is loaded on the first execution of Singleton.getInstance()
	 * or the first access to SingletonHolder.INSTANCE, not before.
	 */
	private static class SingletonHolder {
		private static final Restaurant INSTANCE = new Restaurant();
	}

	public static synchronized Restaurant getInstance() {
		return SingletonHolder.INSTANCE;
	}


	// Menu ------------------------------------------------------------------

	public RestaurantMenu getMenu(String id) {
		return menus.get(id);
	}

	public List<RestaurantMenu> getAllMenus() {
		List<RestaurantMenu> allMenus = new ArrayList<RestaurantMenu>();

		for (RestaurantMenu menu: menus.values())
			allMenus.add(menu);

		return allMenus; 
	}

	public void addMenu(RestaurantMenu menu, int quantity) {
		menus.put(menu.getId(), menu);
		quantities.put(menu.getId(), quantity);
	}

	public boolean hasEnough(String id, int quantity) {
		return (quantities.get(id) >= quantity ? true : false);
	}

	public synchronized String orderMenu(String id, int quantity) {
		if (quantities.get(id) >= quantity) {

			int newQuantity = quantities.get(id) - quantity;
			quantities.replace(id, newQuantity);
			
			Integer orderId = new Integer(orderIdCounter.getAndIncrement());
			return orderId.toString();
		}

		return null;
	}

	public void clear() {
		menus = new ConcurrentHashMap<>();
		quantities = new ConcurrentHashMap<>();
		orderIdCounter = new AtomicInteger(0);
	}
	
}
