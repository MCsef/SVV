package exception;

public class FailedLoadingConfigurationException extends Exception {
	
	public FailedLoadingConfigurationException(String message) {
		super("Configuration exception: Configuration was not found");
	}
}
