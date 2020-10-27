package exception;

public class InvalidMaintenanceDirectoryException extends Exception{

	public InvalidMaintenanceDirectoryException() {
		super("Not a valid maintenance directory!");
	}
}
