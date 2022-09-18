package com.forkexec.hub.ws.it;

import com.forkexec.hub.ws.*;
import org.junit.Assert;

import org.junit.Test;
import java.util.List;

/**
 * Class that tests search menus operation
 */
public class LoadAccountIT extends BaseIT {

    @Override
    public void populate4Test() throws InvalidUserIdFault_Exception{
    }

    @Test
    public void success() throws InvalidUserIdFault_Exception{
        int points = client.accountBalance(email);

        Assert.assertEquals(100, points);
    }

    @Test(expected = InvalidCreditCardFault_Exception.class)
    public void badCreditCard() throws InvalidUserIdFault_Exception, InvalidCreditCardFault_Exception,
                                    InvalidMoneyFault_Exception {
        client.loadAccount(email, 10, "abc024007102923926");
    }

    @Test
    public void addTenPoints() throws InvalidUserIdFault_Exception, InvalidCreditCardFault_Exception,
                                    InvalidMoneyFault_Exception {
        client.loadAccount(email, 10, "4024007102923926");
        int points = client.accountBalance(email);
        
        Assert.assertEquals(1100, points);
    }

    // More specific points tests done on points module

}
