package com.forkexec.hub.ws.it;

import com.forkexec.hub.ws.*;
import org.junit.Assert;

import org.junit.Test;
import java.util.List;

/**
 * Class that tests search menus operation
 */
public class ActivateUserIT extends BaseIT {

    @Override
    public void populate4Test() throws InvalidUserIdFault_Exception{
    }

    @Test(expected = InvalidUserIdFault_Exception.class)
    public void badUserId() throws InvalidUserIdFault_Exception {
        String email = "john.does ervice";
        client.activateAccount(email);
    }

    /*@Test(expected = InvalidUserIdFault_Exception.class)
    public void duplicateUserId() throws InvalidUserIdFault_Exception {
        String email = "john.doe@service";
        client.activateAccount(email);
    }*/

    @Test
    public void simple() throws InvalidUserIdFault_Exception {
        client.activateAccount("abc@service");
    }

    // More specific tests are done on points module

}
