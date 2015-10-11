import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class JServer {

	private int portNumber = 5123;
	private ServerSocket serverSocket = null;
	private Socket socket = null;
	public JServer()
	{
		try
		{
			serverSocket = new ServerSocket(portNumber);
			System.out.println("Waiting for a Client");
			socket = serverSocket.accept();	
			acceptConnection();
		}
		catch(IOException e){}
		
	}
	public void acceptConnection()
	{
		try
		{
			PrintWriter serverOutput = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader serverInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			JMessage initialMessage;
			initialMessage = new JMessage(serverInput.readLine());
			if(initialMessage.string_return() == "Hey! Want to chat?");
			{
				
			}
		}
		catch(IOException e){}
	}
}
