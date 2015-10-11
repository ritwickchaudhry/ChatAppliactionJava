import java.util.Date;
import java.sql.Timestamp;

public class JPacket {
	private Date date;
	private Timestamp timestamp;
	private JMessage message;
	public JPacket(JMessage message_string)
	{
		message = message_string;
		date = new Date();
		date = new java.sql.Timestamp(date.getTime());
	}
	public Timestamp timestamp_return()
	{
		return timestamp;
	}
	public JMessage message_return()
	{
		return message;
	}
}	
