package com.forkexec.hub.ws.it;

import com.forkexec.hub.ws.*;
import org.junit.Assert;

import org.junit.Test;
import java.util.List;
import java.util.ArrayList;

/**
 * Class that tests search menus operation
 */
public class CartIT extends BaseIT {

    @Override
    public void populate4Test() throws InvalidFoodIdFault_Exception, InvalidFoodQuantityFault_Exception,
                                        InvalidUserIdFault_Exception, InvalidInitFault_Exception {

		// Register foods
		List<FoodInit> finits = new ArrayList<>();

		FoodInit finit1 = createFoodInit("A51_Restaurant1", "1", "B_entree", "B_plate", "B_dessert", 50, 30, 100);
		FoodInit finit2 = createFoodInit("A51_Restaurant2", "2", "A_entree", "A_plate", "A_dessert", 10, 15, 100);

		finits.add(finit1);
		finits.add(finit2);

		client.ctrlInitFood(finits);

        client.addFoodToCart(email, foodId, 1);
    }

    @Test
    public void listCartContent() throws InvalidUserIdFault_Exception, InvalidFoodQuantityFault_Exception {
        int listSize = 0;
        FoodId id = new FoodId();

        List<FoodOrderItem> items = client.cartContents(email);

        for (FoodOrderItem item: items) {
            listSize++;

            id = item.getFoodId();
        }

        Assert.assertEquals(1, listSize);
        Assert.assertEquals(foodId.getRestaurantId(), id.getRestaurantId());
        Assert.assertEquals(foodId.getMenuId(), id.getMenuId());
    }

    @Test
    public void clearCartContent() throws InvalidUserIdFault_Exception, InvalidFoodQuantityFault_Exception {
        client.clearCart(email);
        List<FoodOrderItem> items = client.cartContents(email);

        Assert.assertTrue(items.size() == 0);
    }

    // More specific restaurant tests done on restaurant module

}
