package com.forkexec.pts.ws.it;

import static org.junit.Assert.assertEquals;

import com.forkexec.pts.ws.cli.exception.EmailAlreadyExistsFaultException;
import com.forkexec.pts.ws.cli.exception.InvalidEmailFaultException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.forkexec.pts.ws.BadInitFault_Exception;

public class PointsBalanceIT extends BaseIT {
	@Before
	public void setUp() throws EmailAlreadyExistsFaultException, InvalidEmailFaultException, BadInitFault_Exception {
		client.ctrlInit(USER_POINTS);
		client.activateUser(VALID_USER);
	}

	@After
	public void tearDown() {
		pointsTestClear();
	}

	@Test
	public void initialBalanceTest() throws InvalidEmailFaultException {
		assertEquals(USER_POINTS, client.pointsBalance(VALID_USER));
	}

	@Test(expected = InvalidEmailFaultException.class)
	public void unknownUserTest() throws InvalidEmailFaultException {
		client.pointsBalance(UNKNOWN_USER);
	}

	@Test(expected = InvalidEmailFaultException.class)
	public void nullEmailTest() throws InvalidEmailFaultException {
		client.pointsBalance(null);
	}

}
