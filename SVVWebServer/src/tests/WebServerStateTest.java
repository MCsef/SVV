package tests;

import org.junit.Test;
import static org.junit.Assert.*;
import exception.FailedWebServerTransitionException;
import webserver.WebServerState;

public class WebServerStateTest {

	@Test
	public void testValidIsStoppedWhenInitialized() {
		WebServerState state = new WebServerState();
		assertTrue(state.isStopped());
	}

	@Test
	public void testValidSetRunningFromStopped() throws FailedWebServerTransitionException {
		WebServerState state = new WebServerState();
		state.setRunning();		
	}

	@Test (expected = FailedWebServerTransitionException.class)
	public void testInvalidSetMaintenanceFromStopped() throws FailedWebServerTransitionException{
		WebServerState state = new WebServerState();
		state.setMaintenance();		
	}

	@Test 
	public void testValidSetMaintenanceFromRunning() throws FailedWebServerTransitionException{
		WebServerState state = new WebServerState();
		state.setRunning();
		state.setMaintenance();		
	}

	@Test 
	public void testValidSetRunningFromMaintenance() throws FailedWebServerTransitionException{
		WebServerState state = new WebServerState(); 
		state.setRunning();	
		state.setMaintenance();
		state.setRunning();		
	}
	
}
