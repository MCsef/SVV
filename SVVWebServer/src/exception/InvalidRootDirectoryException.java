package exception;

public class InvalidRootDirectoryException extends Exception {
	
	public InvalidRootDirectoryException() {
		super("Not a valid root directory!");
	}
}
