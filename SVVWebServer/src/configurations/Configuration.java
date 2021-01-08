package configurations;
import java.io.FileReader;
import java.util.Properties;

import exception.FailedLoadingConfigurationException;
import exception.FailedSavingConfigurationException;

public class Configuration 
{
	String configurationFileName;
	private FileReader reader;
	private Properties prop;
	
	public Configuration(String configurationFileName){
		this.configurationFileName=configurationFileName;
	}
	
	public void loadConfiguration(String configuration) throws FailedLoadingConfigurationException {	
	}
	
	public void saveConfiguration() throws FailedSavingConfigurationException{	
	}
	
	public String getSetting(String key) {
		return null;
	}
	
	public boolean setSetting(String key, String name) {
		return false;
	}
}
