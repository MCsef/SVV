package exception;

public class FailedWebServerTransitionException extends Exception{

	public FailedWebServerTransitionException() {
		super("State transition failed");
	}
	
}
