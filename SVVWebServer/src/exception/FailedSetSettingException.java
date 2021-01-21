package exception;

public class FailedSetSettingException extends Exception{
	public FailedSetSettingException() {
		super("Configuration File exception: Setting was not set");
	}
}
