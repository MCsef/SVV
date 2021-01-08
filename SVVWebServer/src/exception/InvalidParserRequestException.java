package exception;

public class InvalidParserRequestException extends Exception{

	public InvalidParserRequestException(String message) {
		super(message);
	}

	public InvalidParserRequestException() {
		super("Invalid Request Parser Exception");
	}
	
}
