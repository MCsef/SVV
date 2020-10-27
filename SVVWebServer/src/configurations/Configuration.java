package configurations;
import exception.FailedLoadingConfigurationException;
import exception.FailedSavingConfigurationException;

public class Configuration 
{
	String configurationFileName;
	
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
