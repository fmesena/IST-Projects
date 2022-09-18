package com.forkexec.rst.ws.it;

import com.forkexec.rst.ws.*;

import org.junit.Test;

/**
 * Class that tests init operation
 */
public class OrderMenuIT extends BaseIT {

    /*
    public class MenuOrder {

    protected MenuOrderId id;   public class MenuOrderId { String id; }
    protected MenuId menuId;    public class MenuId { String id; }
    protected int menuQuantity;
    */

    /*@Override
    public void populate4Test() throws BadInitFault_Exception {
        menus.add(createMenuInit(id, "Rey", "Mysterio", "SanDiego", 619, 619, quantity));
        client.ctrlInit(menus);
    }*/

    @Test
    public void success() {
        //try all kind of orders, then AssertNotNull each one...
    }

    @Test
    public void successCheckOrders() {
        // igual ao "success" mas inspeccionar o conteúdo...
    }

    @Test(expected = BadMenuIdFault_Exception.class)
    public void nullMenuId() throws BadMenuIdFault_Exception, InsufficientQuantityFault_Exception, BadQuantityFault_Exception {
        client.orderMenu(null, quantity);
    }

    @Test(expected = BadMenuIdFault_Exception.class)
    public void noSuchOrder() throws BadMenuIdFault_Exception, InsufficientQuantityFault_Exception, BadQuantityFault_Exception {
        client.orderMenu(createMenuId("idonotexist"), quantity);
    }

    @Test(expected = BadQuantityFault_Exception.class)
    public void negativeQuantity() throws BadMenuIdFault_Exception, InsufficientQuantityFault_Exception, BadQuantityFault_Exception {
        client.orderMenu(createMenuId(id), (-1)*quantity);
    }

    @Test(expected = InsufficientQuantityFault_Exception.class)
    public void notEnoughStock() throws BadMenuIdFault_Exception, InsufficientQuantityFault_Exception, BadQuantityFault_Exception {
        client.orderMenu(createMenuId(id), quantity+1);
    }

    @Test
    public void limitEnoughStock() throws BadMenuIdFault_Exception, InsufficientQuantityFault_Exception, BadQuantityFault_Exception {
        client.orderMenu(createMenuId(id), quantity);
    }

}
