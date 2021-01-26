package webserver;

import exception.FailedWebServerTransitionException;
import validators.StateValidator;

public class WebServerState {

	private static final int stopped =1 ;
	private static final int running = 2;
	private static final int maintenance = 3;
	private static int state;

	public WebServerState() {
		this.state=stopped;
	}
	
	public static void init(){
		state=stopped;
    }

	public static boolean isStopped() {
		return (state==stopped)? true: false;	
	}

	public static boolean isRunning() {
		return (state==running)? true: false;
	}

	public static boolean isMaintenance() {
		return (state==maintenance)? true: false;
	}

	public static void setStopped() throws FailedWebServerTransitionException {
		if(!StateValidator.validateSetStopped(stopped)) {
			throw new FailedWebServerTransitionException();
		}
		state=stopped;
	}

	public static void setRunning() throws FailedWebServerTransitionException {
		if(!StateValidator.validateSetStopped(running)) {
			throw new FailedWebServerTransitionException();
		}
		state=running;
	}

	public static void setMaintenance() throws FailedWebServerTransitionException {
		if(!StateValidator.validateSetStopped(maintenance)) {
			throw new FailedWebServerTransitionException();
		}
		state=maintenance;
	}
	
	public static int getWebServerState(){
        return state;
    }
	
}
