package com.forkexec.pts.ws.it;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import com.forkexec.pts.ws.cli.exception.EmailAlreadyExistsFaultException;
import com.forkexec.pts.ws.cli.exception.InvalidEmailFaultException;
import com.forkexec.pts.ws.cli.exception.InvalidPointsFaultException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.forkexec.pts.ws.BadInitFault_Exception;

public class AddPointsIT extends BaseIT {
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
	public void addPointsTest() throws InvalidPointsFaultException, InvalidEmailFaultException {
		client.addPoints(VALID_USER, 1100);
		assertEquals(USER_POINTS + 1100, client.pointsBalance(VALID_USER));
	}

	@Test
	public void noPaymentTest() throws InvalidEmailFaultException {
		try {
			client.addPoints(VALID_USER, 0);
			fail();
		} catch (InvalidPointsFaultException e) {
			assertEquals(USER_POINTS, client.pointsBalance(VALID_USER));
		}
	}

	@Test
	public void negativeValueTest() throws InvalidEmailFaultException {
		try {
			client.addPoints(VALID_USER, -10);
			fail();
		} catch (InvalidPointsFaultException e) {
			assertEquals(USER_POINTS, client.pointsBalance(VALID_USER));
		}
	}

	@Test(expected = InvalidEmailFaultException.class)
	public void unknownUserTest() throws InvalidPointsFaultException, InvalidEmailFaultException {
		client.addPoints(UNKNOWN_USER, 10);
	}

	@Test(expected = InvalidEmailFaultException.class)
	public void nullEmailTest() throws InvalidPointsFaultException, InvalidEmailFaultException {
		client.addPoints(null, 10);
	}
}
