package tests;

import org.junit.Test;

import exception.FailedWebServerTransitionException;
import exception.WebServerStateException;
import webserver.WebServerState;
import exception.WebServerAlreadyInactiveException;
import exception.WebServerMaintenanceTransitionFailException;
import exception.WebServerAlreadyRunningException;

public class WebServerTest {
	
	 @Test
	    public void testStartStoppedWebServer() throws WebServerStateException, FailedWebServerTransitionException{
	        WebServerState.init();
	        WebServerState.setRunning();
	    }

	    @Test
	    public void testStartMaintenanceWebServer() throws WebServerStateException, FailedWebServerTransitionException{
	        WebServerState.init();
	        WebServerState.setRunning();
	        WebServerState.setMaintenance();
	        WebServerState.setRunning();
	    }

	    @Test
	    public void testMaintenanceRunningWebServer() throws WebServerStateException, FailedWebServerTransitionException{
	        WebServerState.init();
	        WebServerState.setRunning();
	        WebServerState.setMaintenance();
	    }

	    @Test
	    public void testStopRunningWebServer() throws WebServerStateException, FailedWebServerTransitionException{
	        WebServerState.init();
	        WebServerState.setRunning();
	        WebServerState.setStopped();
	    }


	    @Test
	    public void testStopInMaintenanceWebServer() throws WebServerStateException, FailedWebServerTransitionException{
	        WebServerState.init();
	        WebServerState.setRunning();
	        WebServerState.setMaintenance();
	        WebServerState.setStopped();
	    }


	    @Test(expected = WebServerAlreadyInactiveException.class)
	    public void testStopStoppedWebServer() throws WebServerStateException, FailedWebServerTransitionException{
	        WebServerState.init();
	        WebServerState.setStopped();
	    }


	    @Test(expected = WebServerMaintenanceTransitionFailException.class)
	    public void testMaintenanceStoppedWebServer() throws WebServerStateException, FailedWebServerTransitionException{
	        WebServerState.init();
	        WebServerState.setMaintenance();
	    }

	    @Test(expected = WebServerAlreadyRunningException.class)
	    public void testStartRunningWebServer() throws FailedWebServerTransitionException {
	        WebServerState.init();
	        WebServerState.setRunning();
	        WebServerState.setRunning();
	    }

}
