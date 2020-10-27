package configurations;
import exception.InvalidPortException;
import exception.InvalidMaintenanceDirectoryException;
import exception.InvalidRootDirectoryException;
import validators.*;

public class Persist {
	private String rootDirectory = "C:\\www_root";
	private String maintenanceDirectory = "C:\\www_root\\maintn";
	private int portNumber = 8080;
	
	public int getPort() {
		return portNumber;
	}
	
	public String getRootDirectory() {
		return rootDirectory;
	}
	
	public String getMaintenanceDirectory() {
		return maintenanceDirectory;
	}
	
	public void setPort(int portNumber) throws InvalidPortException {
		if(!PortNumberValidator.validate(portNumber))
			throw new InvalidPortException();
		this.portNumber = portNumber;
	}
	
	public void setRootDirectory(String rootDirectory) throws InvalidRootDirectoryException {
		if(!RootDirectoryValidator.validate(rootDirectory))
			throw new InvalidRootDirectoryException();
		this.rootDirectory = rootDirectory;
	}
	
	public void setMaintenanceDirectory(String maintenanceDirectory) throws InvalidMaintenanceDirectoryException {
		if(!MaintenanceDirectoryValidator.validate(maintenanceDirectory))
			throw new InvalidMaintenanceDirectoryException();
		this.maintenanceDirectory = maintenanceDirectory;
	}
}