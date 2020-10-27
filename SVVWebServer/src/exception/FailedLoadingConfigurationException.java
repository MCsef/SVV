package exception;

public class FailedLoadingConfigurationException extends Exception {
	
	public FailedLoadingConfigurationException() {
		super("Loaded Configuration Failure");
	}
}
