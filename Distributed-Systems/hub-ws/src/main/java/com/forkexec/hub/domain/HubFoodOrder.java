package com.forkexec.hub.domain;

import java.util.ArrayList;
import java.util.List;

public class HubFoodOrder {

    private String                 orderId;
    private List<HubFoodOrderItem> orders;

    public HubFoodOrder(String orderId, ArrayList<HubFoodOrderItem> item) {
        this.orders = item;
        this.orderId = orderId;
    }

    public List<HubFoodOrderItem> getFoodOrderItems(){
        return orders;
    }

    public void addFoodOrderItems(HubFoodOrderItem foodOrderItem) {
        orders.add(foodOrderItem);
    }

    public void clearItemsOrdered() { orders = new ArrayList<>(); }

    public String getId() {
        return this.orderId;
    }

}
