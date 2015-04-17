package onCallMessage;

// See HOW TO document to get this code working on your machine
 
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
 
import java.util.ArrayList;
import java.util.List;
 
public class OnCallMessage {
 
	 // Find your Account Sid and Token at twilio.com/user/account - copy and paste the two here
	 // Use the 
	 public static final String ACCOUNT_SID = "AC07b7cb4145459129963325d0f17c313e"; 
	 public static final String AUTH_TOKEN = "0964fcad2d1b37b8d1d3b91e91af13b8"; 
	 
	 public static void main(String[]args) throws TwilioRestException { 
		TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN); 
	 
		 // Build the parameters 
		 List<NameValuePair> params = new ArrayList<NameValuePair>(); 
		 params.add(new BasicNameValuePair("Body", "Emergency come to hosiptal"));
		 //staff numbers message sent to
		 params.add(new BasicNameValuePair("To", "+447850574442")); // this is your number
		 //twilio number used to send message
		 params.add(new BasicNameValuePair("From", "+441915801934")); // this is a number twilio provides - see note in word file  
	 
		 MessageFactory messageFactory = client.getAccount().getMessageFactory(); 
		 Message message = messageFactory.create(params); 
		 System.out.println(message.getSid()); 
	 } 
	 
	}