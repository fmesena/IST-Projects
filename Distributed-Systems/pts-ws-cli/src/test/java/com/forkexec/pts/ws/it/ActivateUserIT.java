package com.forkexec.pts.ws.it;

import static org.junit.Assert.assertEquals;

import com.forkexec.pts.ws.cli.PointsClientException;
import com.forkexec.pts.ws.cli.exception.EmailAlreadyExistsFaultException;
import com.forkexec.pts.ws.cli.exception.InvalidEmailFaultException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.forkexec.pts.ws.BadInitFault_Exception;

/*
 * Class tests if the user creation has succeeded or not
 */
public class ActivateUserIT extends BaseIT {

	// one-time initialization and clean-up
	@BeforeClass
	public static void oneTimeSetUp() {
	}

	@AfterClass
	public static void oneTimeTearDown() {
	}

	// members

	// initialization and clean-up for each test
	@Before
	public void setUp() throws BadInitFault_Exception {
		client.ctrlInit(USER_POINTS);
	}

	@After
	public void tearDown() {
		pointsTestClear();
	}

	@Test
	public void createUserValidTest() throws EmailAlreadyExistsFaultException, InvalidEmailFaultException {
		client.activateUser(VALID_USER);
		assertEquals(USER_POINTS, client.pointsBalance(VALID_USER));
	}

	@Test
	public void createUserDotValidTest() throws EmailAlreadyExistsFaultException, InvalidEmailFaultException {
		String email = "sd.teste@tecnico";
		client.activateUser(email);
		assertEquals(USER_POINTS, client.pointsBalance(email));
	}

	@Test
	public void createShortUserValidTest() throws EmailAlreadyExistsFaultException, InvalidEmailFaultException {
		String email = "sd@tecnico";
		client.activateUser(email);
		assertEquals(USER_POINTS, client.pointsBalance(email));
	}

	/*@Test(expected = EmailAlreadyExistsFaultException.class)
	public void createUserDuplicateTest() throws EmailAlreadyExistsFaultException, InvalidEmailFaultException {
		client.activateUser(VALID_USER);
		client.activateUser(VALID_USER);
	}*/

	@Test(expected = InvalidEmailFaultException.class)
	public void createUserInvalidEmail1Test() throws EmailAlreadyExistsFaultException, InvalidEmailFaultException {
		String email = "@tecnico.ulisboa";
		client.activateUser(email);
	}

	@Test(expected = InvalidEmailFaultException.class)
	public void createUserInvalidEmail2Test() throws EmailAlreadyExistsFaultException, InvalidEmailFaultException {
		String email = "teste";
		client.activateUser(email);
	}

	@Test(expected = InvalidEmailFaultException.class)
	public void createUserInvalidEmail3Test() throws EmailAlreadyExistsFaultException, InvalidEmailFaultException {
		String email = "teste@tecnico.";
		client.activateUser(email);
	}

	@Test(expected = InvalidEmailFaultException.class)
	public void createUserInvalidEmail4Test() throws EmailAlreadyExistsFaultException, InvalidEmailFaultException {
		String email = "sd.@tecnico";
		client.activateUser(email);
	}

	@Test(expected = InvalidEmailFaultException.class)
	public void createUserNullEmailTest() throws EmailAlreadyExistsFaultException, InvalidEmailFaultException {
		client.activateUser(null);
	}

}
