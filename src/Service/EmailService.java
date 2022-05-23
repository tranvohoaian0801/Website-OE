package Service;

import javax.servlet.ServletContext;

import Entity.User;


public interface EmailService {
	void sendEmail(ServletContext context, User recipient, String type);
}
