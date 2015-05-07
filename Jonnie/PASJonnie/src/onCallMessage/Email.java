package onCallMessage;

/**
 * This class sends an email to the hospital manager in emergency situations 
 * @author Vicky
 */


import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email{
 
	/**
	 * Method to send an email to the hospital manager when all treatment rooms are
	 * occupied by emergency patients
	 */
	public static void sendEmail1(){
 
		//email address that is sending message
		final String username = "hostipalmanager@gmail.com";
		//password of email account sending message
		final String password = "hospital12";
 
		//system properties
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		//get the default session object
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		try {
			//create a default mime message object
			Message message = new MimeMessage(session);
			//Set From: header field of the header.
			message.setFrom(new InternetAddress("hostipalmanager@gmail.com"));
			//email address message is sent to
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("hostipalmanager@gmail.com"));
			//subject title
			message.setSubject("Hospital Emergency");
			//message	
			message.setText("Emergency alert! All treatment rooms and on call staff in A&E Department are occupied with patients in"
					+ " emergency conditon. Patients in emergency condition are being directed to other hospitals.");
			//send message
			Transport.send(message);
 
			System.out.println("Message Sent");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
			
			
		}
		
	}
	
	/**
	 * Method to send the hospital manager an email message when non-urgent patients are being redirected to other hospitals.
	 */
	public static void sendEmail2(){
		 
		//email address that is sending message
		final String username = "hostipalmanager@gmail.com";
		//password of email account sending message
		final String password = "hospital12";
 
		//system properties
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		try {
			//create a default mime message object
			Message message = new MimeMessage(session);
			//email account that receives message
			message.setFrom(new InternetAddress("hostipalmanager@gmail.com"));
			//email account message is sent to
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("hostipalmanager@gmail.com"));
			//subject title
			message.setSubject("Hospital Emergency");
			//message	
			message.setText("Emergency alert! Queue in A&E Department is full. Non-Urgent patients are being sent to other hospitals");
			//send message
			Transport.send(message);
			
			System.out.println("Message Sent");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
			
			
		}
		
	}
}