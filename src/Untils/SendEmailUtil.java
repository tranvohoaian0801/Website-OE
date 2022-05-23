package Untils;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmailUtil {
	public static void sendEmail(String host, String port,
            final String userName, final String password, String toAddress,
            String subject, String message) throws AddressException,
	
            MessagingException {
 
        // sets SMTP server properties
		Properties properies = new Properties();
		properies.put("mail.smtp.host", "smtp.gmail.com");
		properies.put("mail.smtp.port", "465");
		properies.put("mail.smtp.auth", "true");
		properies.put("mail.smtp.starttls.enable", "true");
		properies.put("mail.smtp.starttls.required", "true");
		properies.put("mail.smtp.ssl.protocols", "TLSv1.2");
		properies.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
 
        // creates a new session with an authenticator
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        };
 
        Session session = Session.getInstance(properies, auth);
 
        // creates a new e-mail message
        Message msg = new MimeMessage(session);
 
        msg.setFrom(new InternetAddress(userName));
        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        msg.setSentDate(new Date());
        msg.setText(message);
 
        // sends the e-mail
        Transport.send(msg);
 
    }
}
