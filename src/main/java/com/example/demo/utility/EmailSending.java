package com.example.demo.utility;

import java.util.Properties;
import java.util.Scanner;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSending {

	public void sendNewUser(String emailTo) {
		String subject = "הרשמה לאתר 'מצאתי'";
		String content = "<h3>נרשמת בהצלחה לאתר 'מצאתי' האתר החברתי לאבידות ומציאות</h3>";
		sendEmail(emailTo, subject, null, content);
	}
	public void sendToUser(String emailTo, String content) {
		String subject = "הרשמה לאתר 'מצאתי'";
		sendEmail(emailTo, subject, null, content);
	}

	private void sendEmail(String emailTo, String subject,String text, String content) {
		String emailFrom = "sara0556785768@gmail.com";
		// Recipient's email ID needs to be mentioned.
		String to = emailTo;

		// Sender's email ID needs to be mentioned
		String from = emailFrom;

		// Assuming you are sending email from through gmails smtp
		String host = "smtp.gmail.com";

		// Get system properties
		Properties properties = System.getProperties();
		// Setup mail server
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		// Get the Session object.// and pass username and password
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(emailFrom, "s5a6r7a8");
			}

		});

		// Used to debug SMTP issues
		session.setDebug(true);

		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// Set Subject: header field
			message.setSubject(subject);
			if(content != null) {
				message.setContent(content, "text/html");
			}
			// Now set the actual message
			if(text != null) {
				message.setText(text);
			}
			// Send message
			Transport.send(message);
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
}
