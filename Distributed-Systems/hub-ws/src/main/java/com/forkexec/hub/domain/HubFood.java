package com.forkexec.hub.domain;

import java.util.List;
import java.util.ArrayList;

/**
 * HubFood entity
 */
public class HubFood {
    private String restaurantId;
    private String menuId;
    private String entree;
    private String plate;
    private String dessert;
    private int price;
    private int preparationTime;

	/** Create a new menu */
	public HubFood(String restaurantId, String menuId, String entree, String plate, String dessert, int price, int preparationTime) {
		this.restaurantId = restaurantId;
		this.menuId = menuId;
		this.entree = entree;
		this.plate = plate;
		this.dessert = dessert;
		this.price = price;
		this.preparationTime = preparationTime;
	}

	/**
     * Gets the value of the restaurant id property.
     */
    public String getRestaurantId() {
        return restaurantId;
    }

    /**
     * Gets the value of the menu id property.
     */
    public String getMenuId() {
        return menuId;
    }

    /**
     * Sets the value of the menu id property.
     */
    public void setMenuId(String value) {
        this.menuId = value;
    }

    /**
     * Sets the value of the restaurant id property.
     */
    public void setRestaurantId(String value) {
        this.restaurantId = value;
    }

    /**
     * Gets the value of the entree property.
     */
    public String getEntree() {
        return entree;
    }

    /**
     * Sets the value of the entree property.
     */
    public void setEntree(String value) {
        this.entree = value;
    }

    /**
     * Gets the value of the plate property.
     */
    public String getPlate() {
        return plate;
    }

    /**
     * Sets the value of the plate property.
     */
    public void setPlate(String value) {
        this.plate = value;
    }

    /**
     * Gets the value of the dessert property.
     */
    public String getDessert() {
        return dessert;
    }

    /**
     * Sets the value of the dessert property.
     */
    public void setDessert(String value) {
        this.dessert = value;
    }

    /**
     * Gets the value of the price property.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     */
    public void setPrice(int value) {
        this.price = value;
    }

    /**
     * Gets the value of the preparationTime property.
     */
    public int getPreparationTime() {
        return preparationTime;
    }

    /**
     * Sets the value of the preparationTime property.
     */
    public void setPreparationTime(int value) {
        this.preparationTime = value;
    }

    // Aux functions ---------------------------------------------------------

    public boolean isInDescription(String text) {
		if (entree.contains(text))
            return true;
        if (plate.contains(text))
            return true;
        if (dessert.contains(text))
            return true;

		return false;
	}

	/*@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [productId=").append(productId);
		builder.append(", description=").append(description);
		builder.append(", quantity=").append(quantity);
		builder.append(", price=").append(price);
		builder.append("]");
		return builder.toString();
	}*/

}
