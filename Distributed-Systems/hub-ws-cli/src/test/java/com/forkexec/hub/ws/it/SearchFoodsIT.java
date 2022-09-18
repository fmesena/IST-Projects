package com.forkexec.hub.ws.it;

import com.forkexec.hub.ws.*;
import org.junit.Assert;

import org.junit.Test;
import java.util.List;
import java.util.ArrayList;

/**
 * Class that tests search menus operation
 */
public class SearchFoodsIT extends BaseIT {

    @Override
    public void populate4Test() throws InvalidInitFault_Exception {		
		// Register foods
		List<FoodInit> finits = new ArrayList<>();

		FoodInit finit1 = createFoodInit("A51_Restaurant1", "1", "B_entree", "B_plate", "B_dessert", 50, 30, 100);
		FoodInit finit2 = createFoodInit("A51_Restaurant2", "2", "A_entree", "A_plate", "A_dessert", 10, 15, 100);

		finits.add(finit1);
		finits.add(finit2);

		client.ctrlInitFood(finits);
    }

    @Test
    public void searchDeal() throws InvalidTextFault_Exception {
        List<Food> foods = client.searchDeal("entree");

        int previousPrice = -1;
        boolean fails = false;

        for (Food food: foods) {
            int price = food.getPrice();

            if (price < previousPrice)
                fails = true;
        }

        Assert.assertFalse(fails);
    }

    @Test
    public void searchHungry() throws InvalidTextFault_Exception {
        List<Food> foods = client.searchHungry("entree");

        int previousPreparationTime = -1;
        boolean fails = false;

        for (Food food: foods) {
            int preparationTime = food.getPreparationTime();

            if (preparationTime < previousPreparationTime)
                fails = true;
        }

        Assert.assertFalse(fails);
    }

}
