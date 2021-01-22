package handler;

import java.io.BufferedReader;
import java.io.IOException;
import exception.InvalidParserRequestException;
import exception.InvalidRequestException;
import exception.InvalidRequestHTTPVersionException;
import exception.InvalidRequestHostException;
import exception.InvalidRequestMethodException;
import exception.InvalidRequestResourceException;
import parsers.RequestParser;
import webserver.Channel;
import webserver.Request;

public class RequestHandler {

    public static Request getRequest(Channel channel) throws IOException, InvalidRequestException, InvalidRequestMethodException, InvalidParserRequestException, InvalidRequestResourceException, InvalidRequestHostException, InvalidRequestHTTPVersionException {
        String request = readRequest(channel.getClientEnd());
        RequestParser parser = new RequestParser(request);
        return new Request(parser.getMethod(),parser.getResource(),parser.getHost(),parser.getHTTPVersion());
    }

    private static String readRequest(BufferedReader in) throws IOException {
        String inputLine;
        StringBuilder request = new StringBuilder();

        while ((inputLine = in.readLine()) != null) 
        {
            request.append(inputLine + "\r\n");
            if (inputLine.trim().equals(""))
                break;
        }
        return request.toString();
    }
}
