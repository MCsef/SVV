package exception;

public class InvalidHostException extends Exception {

	public InvalidHostException() {
		super("Not a valid host for a request");
	}
}
