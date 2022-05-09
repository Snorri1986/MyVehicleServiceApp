package services;

import models.Mail;

/**
 * Description: interface for sending emails
 *
 * @author Denys Shabelnyk
 * @since w0.10a1.4d1.3m0.0
 */
public interface MailService {

	/**
	 * Description: method for sending emails
	 *
	 * @param mail - instance of Mail class
	 * @since w0.10a1.4d1.3m0.0
	 */
	public void sendEmail(Mail mail);

}
