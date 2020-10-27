package exception;

public class InvalidResourceException extends Exception {
	
	public InvalidResourceException() {
		super("Not a valid resource");
	}
}
