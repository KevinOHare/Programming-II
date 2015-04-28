package onCallMessage;
/*
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

	 public static final String ACCOUNT_SID = "ACbd1c2283f3ce08388849962a45c65c8a"; 
	 public static final String AUTH_TOKEN = "25c9cda6ed1d2dd17d5a8d362082e37a"; 
	 
	 public static void TeamMessage() throws TwilioRestException { 
		TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN); 
	 
		 // Build the parameters 
		 List<NameValuePair> params = new ArrayList<NameValuePair>(); 
		 params.add(new BasicNameValuePair("Body", "Emergency Alert! You are required to attend the hospital immediately"));
		 //staff numbers message sent to
		 params.add(new BasicNameValuePair("To", "+447787945009"));
		 //twilio number used to send message
		 params.add(new BasicNameValuePair("From", "+441249400057"));    
	 
		 MessageFactory messageFactory = client.getAccount().getMessageFactory(); 
		 Message message = messageFactory.create(params); 
		 System.out.println(message.getSid()); 
	 } 
	 
	 public static void ManagerMessage1() throws TwilioRestException {
		 
		 TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN); 
		 
		 List<NameValuePair> params = new ArrayList<NameValuePair>(); 
		 params.add(new BasicNameValuePair("Body", "Emergency Alert! The Accident and Emergency Queue is full."));
		 //staff numbers message sent to
		 params.add(new BasicNameValuePair("To", "+447787945009"));
		 //twilio number used to send message
		 params.add(new BasicNameValuePair("From", "+441249400057"));    
	 
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
		 params.add(new BasicNameValuePair("To", "+447787945009")); //this is your phone number
		 //twilio number used to send message
		 params.add(new BasicNameValuePair("From", "+441249400057"));  // this is a number twilio provides - see note in word file  
   
	 
		 MessageFactory messageFactory = client.getAccount().getMessageFactory(); 
		 Message message = messageFactory.create(params); 
		 System.out.println(message.getSid()); 
	 } 
		 
	 
}*/