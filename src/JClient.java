import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.Scanner;

public class JClient {
private String ip;
private Scanner scanner;
private int portNumber = 5123;
private Socket socket;
private ObjectOutputStream outToServer;
private ObjectInputStream inFromServer;

	public JClient()
	{
		System.out.println("Enter the IP Address of the Server you wish to Chat with");
		scanner = new Scanner(System.in);
		ip = scanner.nextLine();
		CallServer();
	}
	public void CallServer()
	{
		try
		{
			socket = new Socket(ip, portNumber);
			JMessage init_message = new JMessage("Hey! Want to chat?");
			JPacket init_packet = new JPacket(init_message);
			outToServer = new ObjectOutputStream(socket.getOutputStream());
			inFromServer = new ObjectInputStream(socket.getInputStream());
            outToServer.writeObject(init_packet);
            outToServer.flush();
            try{
            	this.wait((long) (5000 + 5000*Math.random()));
            }
            catch(InterruptedException ex){ex.printStackTrace();}
            JPacket init_rec = new JPacket(new JMessage(inFromServer.readObject().message_return().string_return()));
            if(serverIn.readLine() == "Sure!")
            {
            	JChatComm chatbox = new JChatComm(socket);
				while(true)
				{
					
					chatbox.sendMessage();
					chatbox.receiveMessage();
				}
            }
            else
            {
            	System.out.println("Timeout : Couldn't Connect to the Server");
            }
    	}
    	catch(IOException ex){}
	}
}
