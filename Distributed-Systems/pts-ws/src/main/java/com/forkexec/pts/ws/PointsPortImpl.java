package com.forkexec.pts.ws;

import javax.jws.WebService;

import com.forkexec.pts.domain.Points;
import com.forkexec.pts.domain.PointsData;
import com.forkexec.pts.domain.exception.EmailAlreadyExistsFaultException;
import com.forkexec.pts.domain.exception.InvalidEmailFaultException;
import com.forkexec.pts.domain.exception.InvalidPointsFaultException;
import com.forkexec.pts.domain.exception.NotEnoughBalanceFaultException;

/**
 * This class implements the Web Service port type (interface). The annotations
 * below "map" the Java class to the WSDL definitions.
 */
@WebService(
		endpointInterface = "com.forkexec.pts.ws.PointsPortType",
		wsdlLocation = "PointsService.wsdl",
		name = "PointsWebService",
		portName = "PointsPort",
		targetNamespace = "http://ws.pts.forkexec.com/",
		serviceName = "PointsService")
public class PointsPortImpl implements PointsPortType {

	/**
	 * The Endpoint manager controls the Web Service instance during its whole
	 * lifecycle.
	 */
	private final PointsEndpointManager endpointManager;

	/**
	 * Constructor receives a reference to the endpoint manager.
	 */
	public PointsPortImpl(final PointsEndpointManager endpointManager) {
		this.endpointManager = endpointManager;
	}

	// Main operations -------------------------------------------------------


	@Override
	public PointsView read(final String userEmail) {
		final Points points = Points.getInstance();
		PointsData data = points.getAccountPoints(userEmail);

		PointsView view = buildPointsView(data);

		return view;
	}

	@Override
	public void write(final String userEmail, final int pointsToAdd, final int tag) {
		final Points points = Points.getInstance();
		points.setAccountPoints(userEmail, pointsToAdd, tag);
	}

	// Control operations ----------------------------------------------------

	/**
	 * Diagnostic operation to check if service is running.
	 */
	@Override
	public String ctrlPing(String inputMessage) {
		// If no input is received, return a default name.
		if (inputMessage == null || inputMessage.trim().length() == 0)
			inputMessage = "friend";

		// If the service does not have a name, return a default.
		String wsName = endpointManager.getWsName();
		if (wsName == null || wsName.trim().length() == 0)
			wsName = PointsApp.class.getSimpleName();

		// Build a string with a message to return.
		final StringBuilder builder = new StringBuilder();
		builder.append("Hello ").append(inputMessage);
		builder.append(" from ").append(wsName);
		return builder.toString();
	}

	/**
	 * Return all variables to default values.
	 */
	@Override
	public void ctrlClear() {
		Points.getInstance().reset();
	}

	/**
	 * Set variables with specific values.
	 */
	@Override
	public void ctrlInit(final int startPoints) throws BadInitFault_Exception {
		if(startPoints < 0)
			throwBadInit("StartPoints should be a positive number");
		Points.getInstance().setInitialBalance(startPoints);
	}



	// View helpers ----------------------------------------------------------

	/** Helper to convert a domain station to a view. */
	private PointsView buildPointsView(PointsData data) {
		PointsView view = new PointsView();

		view.setValue(data.getPoints().get());
		view.setTag(data.getTag());

		return view;
	}

	// Exception helpers -----------------------------------------------------

	/**
	 * Helper to throw a new BadInit exception.
	 */
	private void throwBadInit(final String message) throws BadInitFault_Exception {
		final BadInitFault faultInfo = new BadInitFault();
		faultInfo.message = message;
		throw new BadInitFault_Exception(message, faultInfo);
	}

}
