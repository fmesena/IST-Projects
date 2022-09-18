package com.forkexec.rst.ws.it;

import com.forkexec.rst.ws.BadTextFault_Exception;
import com.forkexec.rst.ws.Menu;
import org.junit.Assert;

import org.junit.Test;
import java.util.List;


/**
 * Class that tests search menus operation
 */
public class SearchMenusIT extends BaseIT {

    @Test
    public void success() throws BadTextFault_Exception {
        List<Menu> searchEntree = client.searchMenus(entree);
        List<Menu> searchPlate = client.searchMenus(plate);
        List<Menu> searchDessert = client.searchMenus(dessert);
        Assert.assertTrue(searchEntree.size() > 0);
        Assert.assertTrue(searchPlate.size() > 0);
        Assert.assertTrue(searchDessert.size() > 0);
    }

    @Test
    public void noSuchMenu() throws BadTextFault_Exception {
        List<Menu> search= client.searchMenus("NoOneWantsDistributedSystemsForLunch...");
        Assert.assertTrue(search.size() == 0);
    }

    @Test(expected = BadTextFault_Exception.class)
    public void badDescriptionNull() throws BadTextFault_Exception {
        client.searchMenus(null);
    }

    @Test(expected = BadTextFault_Exception.class)
    public void badDescriptionSpaces() throws BadTextFault_Exception {
        client.searchMenus("space bar all the way");
    }

    @Test(expected = BadTextFault_Exception.class)
    public void badDescriptionEmpty() throws BadTextFault_Exception {
        client.searchMenus("");
    }

}
