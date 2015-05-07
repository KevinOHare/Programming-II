package onCallMessage;

/**
 * To send automated text messages to the hospital's manger and on call team in emergency situations
 */

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to send appropriate messages to Managers and On Call Team
 * 
 * @author chrismcclune
 *
 */
public class OnCallMessage {
	
	/**
	 * Constant String for the account_sid from Twilio account
	 */
	public static final String ACCOUNT_SID = "ACa88ba7fe3549f739540f8c36fe1ece44";

	/**
	 * Constant String for the Authentication token from Twilio account
	 */
	public static final String AUTH_TOKEN = "67a46d885dbf4292874797d21fe57ca8";

	/**
	 * Alerts the on call team when the queue is full
	 * 
	 * @throws TwilioRestException
	 */
	public static void AlertOnCallTeam() throws TwilioRestException {
		TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);

		// Build the parameters
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("Body",
				"Alert! Queue at hospital is full."));
		// staff numbers message sent to
		params.add(new BasicNameValuePair("To", "+447713901488"));
		// twilio number used to send message
		params.add(new BasicNameValuePair("From", "+441440966046"));

		MessageFactory messageFactory = client.getAccount().getMessageFactory();
		Message message = messageFactory.create(params);
		System.out.println(message.getSid());
	}

	/**
	 * sends hospital manager message when all treatment rooms and on call team
	 * are engaged
	 * 
	 * @throws TwilioRestException
	 */
	public static void ManagerMessage1() throws TwilioRestException {

		TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);

		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair(
				"Body",
				"Emergency Alert! All A&E Department treatment rooms &"
						+ " on call team are occupied with patients in emergency condition. New emergency patients are now being directed "
						+ "to other hospitals"));
		// staff numbers message sent to
		params.add(new BasicNameValuePair("To", "+447787945009"));
		// twilio number used to send message
		params.add(new BasicNameValuePair("From", "+441440966046"));

		MessageFactory messageFactory = client.getAccount().getMessageFactory();
		Message message = messageFactory.create(params);
		System.out.println(message.getSid());

		Email.sendEmail1();
	}

	/**
	 * Sends a message to the hospital manager when 3 or more patients have been
	 * waiting in the queue for over 30 minutes
	 * 
	 * @throws TwilioRestException
	 */
	public static void ManagerMessage2() throws TwilioRestException {

		TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);

		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("Body",
				"Emergency Alert! Patient Waiting Times in Accident and Emergency "
						+ "Department are exceding 30 minutes."));
		// message sent to staff
		params.add(new BasicNameValuePair("To", "+447787945009"));
		params.add(new BasicNameValuePair("From", "+441440966046")); 
		MessageFactory messageFactory = client.getAccount().getMessageFactory();
		Message message = messageFactory.create(params);
		System.out.println(message.getSid());

		Email.sendEmail2();

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