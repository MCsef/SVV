package validators;

import exception.FailedWebServerTransitionException;

public class StateValidator {

	private static final int stopped =1 ;
	private static final int running = 2;
	private static final int maintenance = 3;

	public static boolean validateSetStopped(int currentState) {
		return true;
	}

	public static boolean validateSetRunning(int currentState) {
		return true;
	}

	public static boolean validateSetMaintenance(int currentState) throws FailedWebServerTransitionException {
		if(currentState!=running) {
			return false;
		}
		return true;
	}
}