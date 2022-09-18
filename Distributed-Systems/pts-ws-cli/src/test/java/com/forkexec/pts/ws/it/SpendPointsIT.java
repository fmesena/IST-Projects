package com.forkexec.pts.ws.it;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import com.forkexec.pts.ws.cli.exception.EmailAlreadyExistsFaultException;
import com.forkexec.pts.ws.cli.exception.InvalidEmailFaultException;
import com.forkexec.pts.ws.cli.exception.InvalidPointsFaultException;
import com.forkexec.pts.ws.cli.exception.NotEnoughBalanceFaultException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.forkexec.pts.ws.BadInitFault_Exception;

public class SpendPointsIT extends BaseIT {

	@Before
	public void setUp() throws BadInitFault_Exception, EmailAlreadyExistsFaultException, InvalidEmailFaultException {
		client.ctrlInit(USER_POINTS);
		client.activateUser(VALID_USER);
	}

	@After
	public void tearDown() {
		pointsTestClear();
	}

	@Test
	public void spendPointsEnoughBalanceTest()
			throws InvalidEmailFaultException, NotEnoughBalanceFaultException, InvalidPointsFaultException {
		final int toSpend = USER_POINTS / 10;
		client.spendPoints(VALID_USER, toSpend);
		assertEquals(USER_POINTS - toSpend, client.pointsBalance(VALID_USER));
	}

	@Test
	public void spendEntireBalanceTest()
			throws InvalidEmailFaultException, NotEnoughBalanceFaultException, InvalidPointsFaultException {
		client.spendPoints(VALID_USER, USER_POINTS);
		assertEquals(0, client.pointsBalance(VALID_USER));
	}

	@Test(expected = InvalidPointsFaultException.class)
	public void spendNoPointsTest()
			throws InvalidEmailFaultException, NotEnoughBalanceFaultException, InvalidPointsFaultException {
		client.spendPoints(VALID_USER, 0);
	}

	@Test(expected = InvalidEmailFaultException.class)
	public void unknownUserTest()
			throws InvalidEmailFaultException, NotEnoughBalanceFaultException, InvalidPointsFaultException {
		client.spendPoints(UNKNOWN_USER, 20);
	}

	@Test(expected = InvalidEmailFaultException.class)
	public void nullEmailTest()
			throws InvalidEmailFaultException, NotEnoughBalanceFaultException, InvalidPointsFaultException {
		client.spendPoints(null, 20);
	}

	@Test
	public void notEnoughBalanceTest() throws InvalidPointsFaultException, InvalidEmailFaultException {
		try {
			client.spendPoints(VALID_USER, USER_POINTS + 1);
			fail();
		} catch (NotEnoughBalanceFaultException e) {
			assertEquals(USER_POINTS, client.pointsBalance(VALID_USER));
		}
	}
}
