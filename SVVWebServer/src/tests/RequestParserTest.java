package tests;
import org.junit.Test;
import parsers.RequestParser;
import exception.InvalidResourceException;
import exception.InvalidHostException;
import exception.InvalidHttpException;
import exception.InvalidParserRequestException;
import exception.InvalidRequestException;
import exception.InvalidRequestHTTPVersionException;
import exception.InvalidRequestHostException;
import exception.InvalidRequestResourceException;

public class RequestParserTest {

	@Test
	public void testValidResource() throws InvalidParserRequestException, InvalidRequestException, InvalidRequestResourceException 
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
	public void testInvalidResource1() throws InvalidParserRequestException, InvalidRequestException, InvalidRequestResourceException 
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
	public void testInvalidResource2() throws InvalidParserRequestException, InvalidRequestException, InvalidRequestResourceException 
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
	public void testNoResource() throws InvalidParserRequestException, InvalidRequestException, InvalidRequestResourceException 
	{
		RequestParser parser = new RequestParser(null);
		parser.getResource();
	}
	
	@Test
	public void testValidHttp() throws InvalidRequestException, InvalidRequestHTTPVersionException 
	{
		String request = "GET page.txt HTTP/2.0";
		
		RequestParser parser = new RequestParser(request);
		parser.getHTTPVersion();
	}
	
	@Test(expected = InvalidHttpException.class)
	public void testInvalidHTTP() throws InvalidRequestException, InvalidRequestHTTPVersionException 
	{
		String request = "GET |PAGE.TXT HTTP/3.3";
		
		RequestParser parser = new RequestParser(request);
		parser.getHTTPVersion();
	}
	
	@Test
	public void testValidHost() throws InvalidParserRequestException, InvalidRequestException, InvalidRequestHostException 
	{
		RequestParser parser = new RequestParser("host");
		parser.getHost();
	}
	
	@Test(expected = InvalidHostException.class)
	public void testInvalidHost() throws InvalidParserRequestException, InvalidRequestException, InvalidRequestHostException 
	{
		RequestParser parser = new RequestParser(null);
		parser.getHost();
	}
}
