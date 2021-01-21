package tests;
import java.io.IOException;

import org.junit.Test;

import configurations.Configuration;
import configurations.Persist;
import exception.InvalidPortException;
import exception.InvalidRootDirectoryException;
import exception.FailedLoadingConfigurationException;
import exception.FailedSavingConfigurationException;
import exception.FailedSetSettingException;
import exception.InvalidMaintenanceDirectoryException;

public class PersistTest {
	
	Configuration configuration;
	
	@Test(expected = InvalidPortException.class)
	public void testInvalidPortNumber1() throws InvalidPortException, FailedLoadingConfigurationException, IOException, FailedSetSettingException, FailedSavingConfigurationException 
	{
		Persist persist = new Persist(configuration);
		persist.setPort(0);
	}
	
	@Test(expected = InvalidPortException.class)
	public void testInvalidPortNumber2() throws InvalidPortException, FailedLoadingConfigurationException, IOException, FailedSetSettingException, FailedSavingConfigurationException 
	{
		Persist persist = new Persist(configuration);
		persist.setPort(12000);
	}

	
	@Test
	public void testValidPortNumber() throws InvalidPortException, FailedLoadingConfigurationException, IOException, FailedSetSettingException, FailedSavingConfigurationException 
	{
		Persist persist = new Persist(configuration);
		persist.setPort(1024);
	}
	
	@Test(expected = InvalidMaintenanceDirectoryException.class)
	public void testInvalidMaintenanceDirectory1() throws InvalidMaintenanceDirectoryException, FailedLoadingConfigurationException, IOException, FailedSetSettingException, FailedSavingConfigurationException 
	{
		Persist persist = new Persist(configuration);
		persist.setMaintenanceDirectory("direc|tory");
	}
	
	@Test(expected = InvalidMaintenanceDirectoryException.class)
	public void testInvalidMaintenanceDirectory2() throws InvalidMaintenanceDirectoryException, FailedLoadingConfigurationException, IOException, FailedSetSettingException, FailedSavingConfigurationException 
	{
		Persist persist = new Persist(configuration);
		persist.setMaintenanceDirectory("newf.txt");
	}
	
	@Test
	public void testValidSetRootDirectory() throws InvalidRootDirectoryException, FailedLoadingConfigurationException, IOException, FailedSetSettingException, FailedSavingConfigurationException 
	{
		Persist persist = new Persist(configuration);
		persist.setRootDirectory("C:\\New folder\\New Folder");
	}
	
	@Test(expected = InvalidRootDirectoryException.class)
	public void testInvalidSetRootDirectory1() throws InvalidRootDirectoryException, FailedLoadingConfigurationException, IOException, FailedSetSettingException, FailedSavingConfigurationException 
	{
		Persist persist = new Persist(configuration);
		persist.setRootDirectory("file.txt");
	}
	
	@Test(expected = InvalidRootDirectoryException.class)
	public void testInvalidSetRootDirectory2() throws InvalidRootDirectoryException, FailedLoadingConfigurationException, IOException, FailedSetSettingException, FailedSavingConfigurationException 
	{
		Persist persist = new Persist(configuration);
		persist.setRootDirectory("xx|yy");
	}
	
	@Test
	public void testValidMaintenanceDirectory() throws InvalidMaintenanceDirectoryException, FailedLoadingConfigurationException, IOException, FailedSetSettingException, FailedSavingConfigurationException 
	{
		Persist persist = new Persist(configuration);
		persist.setMaintenanceDirectory("mainf");
	}
	
	
}