package onCallMessage;

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

	// Find your Account Sid and Token at twilio.com/user/account
	public static final String ACCOUNT_SID = "ACa88ba7fe3549f739540f8c36fe1ece44";
	public static final String AUTH_TOKEN = "67a46d885dbf4292874797d21fe57ca8";

	/**
	 * Sends a message to the on call team when treatment rooms are full of
	 * emergency patients and another emergency patient enters the queue
	 * Should this be a main method?
	 * 
	 * @param args
	 * @throws TwilioRestException
	 */
	public static void main(String[] args) throws TwilioRestException {
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

	/**
	 * Message sent to manager when queue is full
	 * 
	 * @throws TwilioRestException
	 */
	public static void ManagerMessage1() throws TwilioRestException {

		TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);

		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("Body",
				"Emergency Alert! The Accident and Emergency Queue is full."));
		// staff numbers message sent to
		params.add(new BasicNameValuePair("To", "+447713901488"));
		// twilio number used to send message
		params.add(new BasicNameValuePair("From", "+441440966046"));

		MessageFactory messageFactory = client.getAccount().getMessageFactory();
		Message message = messageFactory.create(params);
		System.out.println(message.getSid());
	}

	/**
	 * Sends a message to manager when patient waiting times exceed 30 minutes
	 * 
	 * @throws TwilioRestException
	 */
	public static void ManagerMessage2() throws TwilioRestException {

		TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);

		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("Body",
				"Emergency Alert! Patient Waiting Times in Accident and Emergency "
						+ "& Department are exceding 30 minutes."));
		// message sent to staff
		params.add(new BasicNameValuePair("To", "+447713901488")); // this is
																	// your
																	// phone
																	// number
		// twilio number used to send message
		params.add(new BasicNameValuePair("From", "+441440966046")); // this is
																		// a
																		// number
																		// twilio
																		// provides
																		// - see
																		// note
																		// in
																		// word
																		// file

		MessageFactory messageFactory = client.getAccount().getMessageFactory();
		Message message = messageFactory.create(params);
		System.out.println(message.getSid());
	}

}
