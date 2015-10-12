import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class JServer {

	private int portNumber = 5123;
	private ServerSocket serverSocket = null;
	private Socket socket = null;
	private ObjectOutputStream outToServer;
	private ObjectInputStream inFromServer;
	private JMessage initialMessage;
	
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
			ObjectOutputStream outFromServer = new ObjectOutputStream(socket.getOutputStream());;
			ObjectInputStream inFromClient = new ObjectInputStream(socket.getInputStream());;
			try{
			JPacket init_recv = (JPacket)inFromClient.readObject();
			}catch(IOException ex){ex.printStackTrace();}
			initialMessage = new JMessage(init_recv.message_return().string_return());
			if(initialMessage.string_return() == "Hey! Want to chat?");
			{
				JChatComm chatbox = new JChatComm(socket);
				while(true)
				{
					chatbox.sendMessage();
					chatbox.receiveMessage();
				}
			}
		}
		catch(IOException e){}
	}
}
