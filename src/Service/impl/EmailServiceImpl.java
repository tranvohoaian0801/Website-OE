package Service.impl;

import javax.servlet.ServletContext;

import Entity.User;
import Service.EmailService;
import Untils.SendEmailUtil;

public class EmailServiceImpl implements EmailService{
	
	private static final String EMAIL_WELCOME_SUBJECT = "Welcome to Online Entertainment";
	private static final String EMAIL_FORGOT_PASSWORD = "Online Entertainment - New password";

	@Override
	public void sendEmail(ServletContext context, User recipient, String type) {
        String host = context.getInitParameter("host");
        String port = context.getInitParameter("port");
        String user = context.getInitParameter("user");
        String pass = context.getInitParameter("pass");	
        try {
			String content = null;
			String subject = null;
			switch(type) {
				case "welcome":
					subject = EMAIL_WELCOME_SUBJECT;
					content = "Dear " + recipient.getId() + ", hope you a good time!";
					break;
				default:
					subject = EMAIL_FORGOT_PASSWORD;
					content = "Dear " + recipient.getId() + ", your new password here: " + recipient.getPassword();
			}
			SendEmailUtil.sendEmail(host, port, user, pass, recipient.getEmail(), subject, content);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
