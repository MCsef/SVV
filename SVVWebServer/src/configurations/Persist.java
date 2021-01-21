package configurations;

import exception.InvalidPortException;

import java.io.IOException;

import exception.FailedGetSettingException;
import exception.FailedLoadingConfigurationException;
import exception.FailedSavingConfigurationException;
import exception.FailedSetSettingException;
import exception.InvalidMaintenanceDirectoryException;
import exception.InvalidRootDirectoryException;
import validators.*;

public class Persist {
	
	private Configuration configuration;
	
	public Persist(Configuration configuration) throws FailedLoadingConfigurationException, IOException {	
		this.configuration = configuration;
		configuration.loadConfiguration();
	}
	
	public int getPort() throws NumberFormatException, FailedGetSettingException {
		return Integer.parseInt(configuration.getSetting("portNumber"));
	}
	
	public String getRootDirectory() throws FailedGetSettingException {
		return configuration.getSetting("rootDirectory");
	}
	
	public String getMaintenanceDirectory() throws FailedGetSettingException {
		return configuration.getSetting("maintenanceDirectory");
	}
	
	public void setPort(int portNumber) throws InvalidPortException, FailedSetSettingException, FailedSavingConfigurationException, IOException {
		if (!PortNumberValidator.validate(portNumber)) {
			throw new InvalidPortException();
		}
		configuration.setSetting("portNumber",String.valueOf(portNumber));
		configuration.saveConfiguration();
	}
	
	public void setRootDirectory(String rootDirectory) throws InvalidRootDirectoryException, FailedSetSettingException, FailedSavingConfigurationException, IOException {
		if(!RootDirectoryValidator.validate(rootDirectory))	
		{
			throw new InvalidRootDirectoryException();
		}
		configuration.setSetting("rootDirectory",rootDirectory);
		configuration.saveConfiguration();
	}
	
	public void setMaintenanceDirectory(String maintenanceDirectory) throws InvalidMaintenanceDirectoryException, FailedSetSettingException, FailedSavingConfigurationException, IOException {
		if(!MaintenanceDirectoryValidator.validate(maintenanceDirectory)) {
			throw new InvalidMaintenanceDirectoryException();
		}
		configuration.setSetting("maintenanceDirectory",maintenanceDirectory);
		configuration.saveConfiguration();
	}
}