package tests;
import org.junit.Test;
import configurations.Persist;
import exception.InvalidPortException;
import exception.InvalidRootDirectoryException;
import exception.InvalidMaintenanceDirectoryException;

public class PersistTest {
	
	@Test(expected = InvalidPortException.class)
	public void testInvalidPortNumber1() throws InvalidPortException 
	{
		Persist persist = new Persist();
		persist.setPort(0);
	}
	
	@Test(expected = InvalidPortException.class)
	public void testInvalidPortNumber2() throws InvalidPortException 
	{
		Persist persist = new Persist();
		persist.setPort(12000);
	}

	
	@Test
	public void testValidPortNumber() throws InvalidPortException 
	{
		Persist persist = new Persist();
		persist.setPort(1024);
	}
	
	@Test(expected = InvalidMaintenanceDirectoryException.class)
	public void testInvalidMaintenanceDirectory1() throws InvalidMaintenanceDirectoryException 
	{
		Persist persist = new Persist();
		persist.setMaintenanceDirectory("direc|tory");
	}
	
	@Test(expected = InvalidMaintenanceDirectoryException.class)
	public void testInvalidMaintenanceDirectory2() throws InvalidMaintenanceDirectoryException 
	{
		Persist persist = new Persist();
		persist.setMaintenanceDirectory("newf.txt");
	}
	
	@Test
	public void testValidSetRootDirectory() throws InvalidRootDirectoryException 
	{
		Persist persist = new Persist();
		persist.setRootDirectory("C:\\New folder\\New Folder");
	}
	
	@Test(expected = InvalidRootDirectoryException.class)
	public void testInvalidSetRootDirectory1() throws InvalidRootDirectoryException 
	{
		Persist persist = new Persist();
		persist.setRootDirectory("file.txt");
	}
	
	@Test(expected = InvalidRootDirectoryException.class)
	public void testInvalidSetRootDirectory2() throws InvalidRootDirectoryException 
	{
		Persist persist = new Persist();
		persist.setRootDirectory("xx|yy");
	}
	
	@Test
	public void testValidMaintenanceDirectory() throws InvalidMaintenanceDirectoryException 
	{
		Persist persist = new Persist();
		persist.setMaintenanceDirectory("mainf");
	}
	
	
}