package com.forkexec.rst.ws.it;


import com.forkexec.rst.ws.*;

import org.junit.Test;


/**
 * Class that tests init operation
 */
public class InitIT extends BaseIT {

    @Override
    public void populate4Test() {
    }
    
    @Test
    public void consecutiveInits() throws BadInitFault_Exception {
        menus.add(createMenuInit("788", "Água", "Pato", "Gelatina", 5, 10, 5));
        menus.add(createMenuInit("41 2", "Água", "Pato", "Gelatina", 5, 10, 5));
        menus.add(createMenuInit("993", "Água", "Pato", "Gelatina", 5, 10, 5));
        client.ctrlInit(menus);
    }

    @Test
    public void idWithSpaces() throws BadInitFault_Exception {
        menus.add(createMenuInit("4 1  23", "Água", "Pato", "Gelatina", 5, 10, 5));
        client.ctrlInit(menus);
    }


    @Test(expected = BadInitFault_Exception.class)
    public void twoEqualMenuIds() throws BadInitFault_Exception {
        menus.add(createMenuInit(id, "Pão", "Carne congelada", "Gelatina", 3, 20, 50));
        client.ctrlInit(menus);
    }

    @Test
    public void twoEqualMenusDiffIds() throws BadInitFault_Exception {
        menus.add(createMenuInit("11", entree, plate, dessert, price, prepTime, quantity));
        client.ctrlInit(menus);
    }

    @Test
    public void ZeroPrepTimeMenu() throws BadInitFault_Exception {
        menus.add(createMenuInit("7111", entree, plate, dessert, price, 0, quantity));
        client.ctrlInit(menus);
    }

    @Test(expected = BadInitFault_Exception.class)
    public void negativePrepTimeMenu() throws BadInitFault_Exception {
        menus.add(createMenuInit("221", entree, plate, dessert, price, -14, quantity));
        client.ctrlInit(menus);
    }

    @Test(expected = BadInitFault_Exception.class)
    public void negativePriceMenu() throws BadInitFault_Exception {
        menus.add(createMenuInit("23", entree, plate, dessert, -12, prepTime, quantity));
        client.ctrlInit(menus);
    }

    @Test(expected = BadInitFault_Exception.class)
    public void ZeroPriceMenu() throws BadInitFault_Exception {
        menus.add(createMenuInit("2", entree, plate, dessert, 0, prepTime, quantity));
        client.ctrlInit(menus);
    }

}
