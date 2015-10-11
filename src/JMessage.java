public class JMessage {
//String message;
private	String message; 
public JMessage(String string)
{
	if(string.length() >= 140)
	{
		message = string.substring(0,140);
	}
	else
	{
		message = string;
	}
}

public String string_return()
{
	return message;
}

}

