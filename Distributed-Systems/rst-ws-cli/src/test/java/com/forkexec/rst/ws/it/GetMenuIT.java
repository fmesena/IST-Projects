package com.forkexec.rst.ws.it;

import com.forkexec.rst.ws.*;

import org.junit.Test;


/**
 * Class that tests getMenu operation
 */
public class GetMenuIT extends BaseIT {

    private MenuId mId;
    private Menu m;

    @Override
    public void populate4Test() {
        mId = new MenuId();
        mId.setId(id);

        m = new Menu();
        m.setId(mId);
        m.setEntree(entree);
        m.setPlate(plate);
        m.setDessert(dessert);
        m.setPrice(price);
        m.setPreparationTime(prepTime);
    }

    @Test
    public void success() throws BadMenuIdFault_Exception {
        assertEqualMenus(client.getMenu(mId), m);
    }

    @Test(expected = BadMenuIdFault_Exception.class)
    public void noSuchMenuId() throws BadMenuIdFault_Exception {
        mId.setId("niil");
        client.getMenu(mId);
    }

    @Test(expected = BadMenuIdFault_Exception.class)
    public void nullMenuId () throws BadMenuIdFault_Exception {
        client.getMenu(null);
    }

}
