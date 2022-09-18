package com.forkexec.hub.domain;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Hub
 *
 * A restaurants hub server.
 *
 */
public class Hub {

	private AtomicInteger orderNum;
	/**
	 * Conversion table EUR->pontos-comes.
	 */
	private static final Map<Integer, Integer> CONVERSION_TABLE = new ConcurrentHashMap<>();
	/**
	 * Cart.
	 */
	private Map<String, HubFoodOrder> cart = new ConcurrentHashMap<>();
	/**
	 * SingletonHolder is loaded on the first execution of Singleton.getInstance()
	 * or the first access to SingletonHolder.INSTANCE, not before.
	 */
	// Singleton -------------------------------------------------------------


	/** Private constructor prevents instantiation from other classes. */
	private Hub() {
		// Initialization of default values
		CONVERSION_TABLE.put(10, 1000);
		CONVERSION_TABLE.put(20, 2100);
		CONVERSION_TABLE.put(30, 3300);
		CONVERSION_TABLE.put(50, 5500);
		orderNum = new AtomicInteger(0);
	}

	private static class SingletonHolder {

		private static final Hub INSTANCE = new Hub();

	}
	public static synchronized Hub getInstance() {
		return SingletonHolder.INSTANCE;
	}

	public synchronized int getPontosComes(int moneyToConvert) {
		switch(moneyToConvert) {
			case 10:
				return CONVERSION_TABLE.get(10);
			case 20:
				return CONVERSION_TABLE.get(20);
			case 30:
				return CONVERSION_TABLE.get(30);
			case 50:
				return CONVERSION_TABLE.get(50);
			default:
				return -1;
		}
	}

	public synchronized void addToCart(String userId, HubFoodOrder order) {
		cart.put(userId, order);
	}

	public synchronized HubFoodOrder getFoodOrder(String userId) {
		return cart.get(userId);
	}

	public synchronized boolean isRegistered(String userId) {
		return cart.get(userId) != null;
	}

	public synchronized String getOrderNum() {
		return this.orderNum.toString();
	}

	public synchronized void incrOrderNum() {
		this.orderNum.incrementAndGet();
	}

	public List<HubFoodOrderItem> getFoodOrderItems(String userId) {
		return getFoodOrder(userId).getFoodOrderItems();
	}

	public void clearCart(String userId) {
		HubFoodOrder userOrder = this.getFoodOrder(userId);
		userOrder.clearItemsOrdered();
	}

	public void clear() {
		this.cart = new ConcurrentHashMap<>();
	}

}
