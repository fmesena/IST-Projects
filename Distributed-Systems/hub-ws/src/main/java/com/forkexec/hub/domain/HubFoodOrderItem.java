package com.forkexec.hub.domain;

public class HubFoodOrderItem {
    protected String restaurantId;
    protected String menuId;
    protected int    foodQuantity;

    public HubFoodOrderItem(String menuId, String restaurantId, int foodQuantity) {
        this.restaurantId = restaurantId;
        this.menuId = menuId;
        this.foodQuantity = foodQuantity;
    }

    /**
     * Gets the value of the foodId property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRestaurantId() {
        return restaurantId;
    }

    /**
     * Sets the value of the foodId property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRestaurantId(String value) {
        this.restaurantId= value;
    }
    /**
     * Gets the value of the menuId property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMenuId() {
        return menuId;
    }

    /**
     * Sets the value of the menuId property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMenuId(String value) {
        this.menuId = value;
    }

    /**
     * Gets the value of the foodQuantity property.
     *
     */
    public int getFoodQuantity() {
        return foodQuantity;
    }

    /**
     * Sets the value of the foodQuantity property.
     *
     */
    public void setFoodQuantity(int value) {
        this.foodQuantity = value;
    }


}
