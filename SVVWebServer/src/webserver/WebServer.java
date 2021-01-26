package webserver;

import java.io.*;
import java.net.*;

public class WebServer extends Thread{
	
	protected Socket clientSocket;
	
	private WebServer(Socket clientSoccket) {
		this.clientSocket = clientSocket;
		start();
	}
	
	public static void runWebServer(int port){
		ServerSocket serverSocket = null;
		try 
		{
			serverSocket = new ServerSocket(10008);
			System.out.println("Socket conntection has been created");
			try 
			{
				while (true) 
				{
					System.out.println("Waiting for connection");
					new WebServer(serverSocket.accept());
				}
			} 
			catch (IOException e) 
			{
				System.err.println("Connection failed");
				System.exit(1);
			}
		} 
		catch (IOException e)
		{
			System.err.println("Could not listen on port: 10008");
			System.exit(1);
		} 
		finally 
		{
			try 
			{
				serverSocket.close();
			} 
			catch (IOException e) 
			{
				System.err.println("Could not close port: 10008");
				System.exit(1);
			}
		}
	}


	public void run() {
		System.out.println("Communication thread has been started");
		try 
		{
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null) 
			{
				System.out.println("Server: " + inputLine);
				out.println(inputLine);
				if (inputLine.trim().equals(""))
					break;
			}
			out.close();
			in.close();
			clientSocket.close();
		}
		catch (IOException e)
		{
			System.err.println("Problem with ommunication server");
			System.exit(1);
		}
	}
	
}
