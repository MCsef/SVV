package tests;
import org.junit.Test;
import parsers.RequestParser;
import exception.InvalidResourceException;
import exception.InvalidHostException;
import exception.InvalidHttpException;
import exception.InvalidParserRequestException;

public class RequestParserTest {

	@Test
	public void testValidResource() throws InvalidParserRequestException 
	{
		String request = "GET / HTTP/1.1 Host: localhost:8080\n" +
                "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:74.0) Gecko/20100101 Firefox/74.0\n" +
                "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8\n" +
                "Accept-Language: en-US,en;q=0.5\n" +
                "Accept-Encoding: gzip, deflate ";
		
		RequestParser parser = new RequestParser(request);
		parser.getResource();
	}
	
	@Test(expected = InvalidResourceException.class)
	public void testInvalidResource1() throws InvalidParserRequestException 
	{
		String request = "GET x HTTP/1.1 Host: localhost:8080\n" +
                "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:74.0) Gecko/20100101 Firefox/74.0\n" +
                "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8\n" +
                "Accept-Language: en-US,en;q=0.5\n" +
                "Accept-Encoding: gzip, deflate ";
		
		RequestParser parser = new RequestParser(request);
		parser.getResource();
	}
	
	@Test(expected = InvalidResourceException.class)
	public void testInvalidResource2() throws InvalidParserRequestException 
	{
		String request = "GET http:\\| Host: localhost:8080\n" +
                "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:74.0) Gecko/20100101 Firefox/74.0\n" +
                "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8\n" +
                "Accept-Language: en-US,en;q=0.5\n" +
                "Accept-Encoding: gzip, deflate ";
		
		RequestParser parser = new RequestParser(request);
		parser.getResource();
	}
	
	@Test(expected = InvalidResourceException.class)
	public void testNoResource() throws InvalidParserRequestException 
	{
		RequestParser parser = new RequestParser(null);
		parser.getResource();
	}
	
	@Test
	public void testValidHttp() 
	{
		String request = "GET page.txt HTTP/2.0";
		
		RequestParser parser = new RequestParser(request);
		parser.getHTTP();
	}
	
	@Test(expected = InvalidHttpException.class)
	public void testInvalidHTTP() 
	{
		String request = "GET |PAGE.TXT HTTP/3.3";
		
		RequestParser parser = new RequestParser(request);
		parser.getHTTP();
	}
	
	@Test
	public void testValidHost() throws InvalidParserRequestException 
	{
		RequestParser parser = new RequestParser("host");
		parser.getHost();
	}
	
	@Test(expected = InvalidHostException.class)
	public void testInvalidHost() throws InvalidParserRequestException 
	{
		RequestParser parser = new RequestParser(null);
		parser.getHost();
	}
}
