import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;



public class JChatComm {
	private Socket socket;
	private ObjectOutputStream outToServer;
    private ObjectInputStream inFromServer;
	private BufferedReader clientInput;
	private PrintWriter clientOut;
	
	public JChatComm(Socket socket_recd)
	{
		socket = socket_recd;
		try{
			outToServer = new ObjectOutputStream(socket.getOutputStream());
			inFromServer = new ObjectInputStream(socket.getInputStream());
		}catch(IOException ex){ex.printStackTrace();}
	}
	public void sendMessage()
	{
		try
		{
			
		}
		catch(IOException ex){ex.printStackTrace();}
	}
	public void receiveMessage()
	{
		try
		{
			
		}
		catch(IOException ex){ex.printStackTrace();}
	}
}
