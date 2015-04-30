package onCallMessage;

/**
 * Sends an email to the hospital manager in emergency situation
 * 
 */

/*  
 * everyone will need to download 2 jars for this to work
 * See word doc by Chris
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
 
	public static void sendEmail1(){
 
		//email address that is sending message
		//its set to a google account anyone can access
		final String username = "hostipalmanager@gmail.com";
		//password of email account sending message
		final String password = "hospital12";
 
		
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
			
			Message message = new MimeMessage(session);
			//email account that recieves message
			message.setFrom(new InternetAddress("hostipalmanager@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("hostipalmanager@gmail.com"));
			//subject title
			message.setSubject("Hospital Emergency");
			//message	
			message.setText("Emergency alert! All treatment rooms and on call staff in A&E Department are occupied with patients in"
					+ " emergency conditon. Patients in emergency condition are being directed to other hospitals.");
 
			Transport.send(message);
 
			System.out.println("Done");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
			
			
		}
		
	}
	public static void sendEmail2(){
		 
		//email address that is sending message
		//its set to a google account anyone can access
		final String username = "hostipalmanager@gmail.com";
		//password of email account sending message
		final String password = "hospital12";
 
		
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
			
			Message message = new MimeMessage(session);
			//email account that recieves message
			message.setFrom(new InternetAddress("hostipalmanager@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("hostipalmanager@gmail.com"));
			//subject title
			message.setSubject("Hospital Emergency");
			//message	
			message.setText("Emergency alert! Queue in A&E Department is full. Non-Urgent patients are being sent to other hospitals");
 
			Transport.send(message);
 
			System.out.println("Done");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
			
			
		}
		
	}
}