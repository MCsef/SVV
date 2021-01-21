package exception;

public class FailedGetSettingException extends Exception{
	public FailedGetSettingException()
	{
		super("Configuration File exception: Setting was not found");
	}
}
