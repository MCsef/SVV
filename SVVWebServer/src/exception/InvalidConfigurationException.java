package exception;

public class InvalidConfigurationException extends Exception {

	public InvalidConfigurationException() {
		super("Not a valid configuration!");
	}
}
