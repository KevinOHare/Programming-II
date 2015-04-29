package onCallMessage;

// See HOW TO document to get this code working on your machine
//everyone will need to download twilio jar 
 
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

	 public static final String ACCOUNT_SID = "ACb6746bac3b7204dcb3a7777879b70a63"; 
	 public static final String AUTH_TOKEN = "c350300591d3c582c5e9f80ade758c3f"; 
	 
	 public static void main(String[]args) throws TwilioRestException { 
		TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN); 
	 
		 // Build the parameters 
		 List<NameValuePair> params = new ArrayList<NameValuePair>(); 
		 params.add(new BasicNameValuePair("Body", "Emergency Alert! You are required to attend the hospital immediately"));
		 //staff numbers message sent to
		 params.add(new BasicNameValuePair("To", "+447543635708"));
		 //twilio number used to send message
		 params.add(new BasicNameValuePair("From", "+441633901163"));    
	 
		 MessageFactory messageFactory = client.getAccount().getMessageFactory(); 
		 Message message = messageFactory.create(params); 
		 System.out.println(message.getSid()); 
	 } 
	 
	 public static void ManagerMessage1() throws TwilioRestException {
		 
		 TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN); 
		 
		 List<NameValuePair> params = new ArrayList<NameValuePair>(); 
		 params.add(new BasicNameValuePair("Body", "Emergency Alert! The Accident and Emergency Queue is full."));
		 //staff numbers message sent to
		 params.add(new BasicNameValuePair("To", "+447543635708"));
		 //twilio number used to send message
		 params.add(new BasicNameValuePair("From", "+441633901163"));    
	 
		 MessageFactory messageFactory = client.getAccount().getMessageFactory(); 
		 Message message = messageFactory.create(params); 
		 System.out.println(message.getSid()); 
	 } 
	 
 public static void ManagerMessage2() throws TwilioRestException {
		 
		 TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN); 
		 
		 List<NameValuePair> params = new ArrayList<NameValuePair>(); 
		 params.add(new BasicNameValuePair("Body", "Emergency Alert! Patient Waiting Times in Accident and Emergency "
		 		+ "& Department are exceding 30 minutes."));
		 //message sent to staff
		 params.add(new BasicNameValuePair("To", "+447543635708")); //this is your phone number
		 //twilio number used to send message
		 params.add(new BasicNameValuePair("From", "+441633901163"));  // this is a number twilio provides - see note in word file  
   
	 
		 MessageFactory messageFactory = client.getAccount().getMessageFactory(); 
		 Message message = messageFactory.create(params); 
		 System.out.println(message.getSid()); 
	 } 
		 
 /**
	 * Sends a message to the on call team when treatment rooms are full of
	 * emergency patients and another emergency patient enters the queue
	 * 
	 * @param args
	 * @throws TwilioRestException
	 */
	public static void OnCallTeamMessage() throws TwilioRestException {
		TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);

		// Build the parameters
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("Body", "Emergency come to hosiptal"));
		// staff numbers message sent to
		params.add(new BasicNameValuePair("To", "+447713901488"));
		// twilio number used to send message
		params.add(new BasicNameValuePair("From", "+441440966046"));

		MessageFactory messageFactory = client.getAccount().getMessageFactory();
		Message message = messageFactory.create(params);
		System.out.println(message.getSid());
	}
	 
}