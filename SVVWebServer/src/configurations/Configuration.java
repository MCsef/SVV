package configurations;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import exception.FailedGetSettingException;
import exception.FailedLoadingConfigurationException;
import exception.FailedSavingConfigurationException;
import exception.FailedSetSettingException;
import validators.ConfigurationFileValidator;

public class Configuration 
{
	String configurationFileName;
	private FileReader reader;
	private Properties prop;
	
	public Configuration(String configurationFileName) throws  IOException, FailedLoadingConfigurationException 
	{
		this.configurationFileName=configurationFileName;
		loadConfiguration();
	}
	
	public void loadConfiguration() throws FailedLoadingConfigurationException, IOException 
	{	
		prop = new Properties();
		try 
		{
			this.reader = new FileReader(configurationFileName);
			if (reader != null)
			{
				prop.load(reader);
			} 
			else 
			{
				throw new FailedLoadingConfigurationException("Input Configuration file '" + configurationFileName + "' not found in the classpath");
			}
		} 
		catch (IOException ex) 
		{
            throw new IOException("Error loading Configuration file");
        }
	}
	
	public void saveConfiguration() throws FailedSavingConfigurationException, IOException
	{	
		try 
		{
			FileWriter output = new FileWriter(this.configurationFileName);
			prop.store(output, "Changed file");
        } 
		catch (IOException ex) 
		{
            throw new IOException("Save Configuration: Error on saveing Config file");
        }
	}
	
	public String getSetting(String key) throws FailedGetSettingException
	{
		String value = prop.getProperty(key);
		if(!ConfigurationFileValidator.validateGetSetting(value)) 
		{
			throw new FailedGetSettingException();
		}
		return value;
	}
	
	public void setSetting(String key, String value) throws FailedSetSettingException 
	{
		prop.setProperty(key, value);
		if(!ConfigurationFileValidator.validateSetSetting(value,prop.getProperty(key)))
		{
			throw new FailedSetSettingException();
		}
	}
}
