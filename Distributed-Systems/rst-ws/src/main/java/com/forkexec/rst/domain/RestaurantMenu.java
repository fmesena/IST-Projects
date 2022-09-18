package com.forkexec.rst.domain;

import java.util.List;
import java.util.ArrayList;

/**
 * RestaurantMenu entity
 */
public class RestaurantMenu {
    private String id;
    private String entree;
    private String plate;
    private String dessert;
    private int price;
    private int preparationTime;

	/** Create a new menu */
	public RestaurantMenu(String id, String entree, String plate, String dessert, int price, int preparationTime) {
		this.id = id;
		this.entree = entree;
		this.plate = plate;
		this.dessert = dessert;
		this.price = price;
		this.preparationTime = preparationTime;
	}

	/**
     * Gets the value of the id property.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     */
    public void setId(String value) {
        this.id = value;
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

    // Aux functions  ----------------------------------------------

    public boolean isInDescription(String text) {
		if (entree.contains(text))
            return true;
        if (plate.contains(text))
            return true;
        if (dessert.contains(text))
            return true;

		return false;
	}

}
