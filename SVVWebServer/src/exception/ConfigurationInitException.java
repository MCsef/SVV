package exception;

public class ConfigurationInitException extends Exception {
	
	public ConfigurationInitException() {
		super("No Initial Configuration provided");
	}

}
