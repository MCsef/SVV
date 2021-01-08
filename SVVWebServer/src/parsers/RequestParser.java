package parsers;

import exception.InvalidParserRequestException;
import validators.ParserRequestValidator;

public class RequestParser {

	private String request;
	
	public RequestParser(String request) {
		this.request = request;
	}
	
	public String getResource() throws InvalidParserRequestException {
		if(!ParserRequestValidator.validateResource(this.request)) {
			throw new InvalidParserRequestException("Invalid resource request");
		}
		return null;
	}
	
	public String getHTTP() {
		return null;
	}
	
	public String getHost() throws InvalidParserRequestException {
		if(!ParserRequestValidator.validateHost(this.request)) {
			throw new InvalidParserRequestException("Invalid host request");
		}
		return null;
	}
}
