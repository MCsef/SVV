package validators;

public class ConfigurationFileValidator {

	public static boolean validateGetSetting(String value)
	{
		if(value!=null) 
		{
			return true;
		}
		return false;
	}

	public static boolean validateSetSetting(String expectedValue, String NewValue){	
		if(expectedValue.equals(NewValue)) 
		{
			return true;
		}
		return false;
	}
}
