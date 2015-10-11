import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.Scanner;

public class JClient {
private String ip;
private Scanner scanner;
private int portNumber = 5123;
private Socket socket;

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
            PrintWriter clientOut = new PrintWriter(socket.getOutputStream(), true);
            clientOut.println("Hey! Want to chat?");
            BufferedReader serverIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        	try
        	{
	            Thread.sleep((long) (5000 + 5000*Math.random()));
	            if(serverIn.readLine() == "Sure!")
	            {
	            	JChatComm chatbox = new JChatComm();
	            }
	            else
	            {
	            	System.out.println("Timeout : Couldn't Connect to the Server");
	            }
        	}
        	}
        	catch(IOException ex){}
	}
}
