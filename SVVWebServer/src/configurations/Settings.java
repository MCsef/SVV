package configurations;

import java.io.IOException;

import exception.FailedLoadingConfigurationException;
import exception.InvalidConfigurationException;

public class Settings {
	
	public static Configuration configuration;
    public static Persist persist;

    public static void init() throws FailedLoadingConfigurationException{
        try 
        {
            configuration = Configuration.getConfig("config/config.properties");
            persist = new Persist(configuration);
        } 
        catch (InvalidConfigurationException e) 
        {
            e.printStackTrace();
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
}
