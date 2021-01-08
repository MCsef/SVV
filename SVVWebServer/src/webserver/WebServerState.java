package webserver;

import exception.FailedWebServerTransitionException;
import validators.StateValidator;

public class WebServerState {

	private static final int stopped =1 ;
	private static final int running = 2;
	private static final int maintenance = 3;

	private int state;

	public WebServerState() {
		this.state=stopped;
	}

	public boolean isStopped() {
		return (this.state==stopped)? true: false;
	}

	public boolean isRunning() {
		return (this.state==running)? true: false;
	}

	public boolean isMaintenance() {
		return (this.state==maintenance)? true: false;
	}

	public void setStopped() throws FailedWebServerTransitionException {
		if(!StateValidator.validateSetStopped(stopped)) {
			throw new FailedWebServerTransitionException();
		}
		this.state=stopped;
	}

	public void setRunning() throws FailedWebServerTransitionException {
		if(!StateValidator.validateSetStopped(running)) {
			throw new FailedWebServerTransitionException();
		}
		this.state=running;
	}

	public void setMaintenance() throws FailedWebServerTransitionException {
		if(!StateValidator.validateSetStopped(maintenance)) {
			throw new FailedWebServerTransitionException();
		}
		this.state=maintenance;
	}
	
}
