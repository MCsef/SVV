package exception;

public class InvalidHttpException extends Exception {

	public InvalidHttpException() {
		super("Not a valid http version");
	}
}
