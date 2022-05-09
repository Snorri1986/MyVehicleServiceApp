package models;

/**
 * Description: Mail class
 *
 * @author Denys Shabelnyk
 * @since w0.10a1.4d1.3m0.0
 */
public class Mail {

	private String mailFrom;

	private String mailTo;

	private String mailSubject;

	private String mailContent;

	private String contentType;

	public Mail() {
		super();
	}

	public Mail(String contentType) {
		super();
		this.contentType = contentType;
	}

	/**
	 * Description: getter for mailFrom variable
	 *
	 * @return String - value of mailFrom variable
	 * @since w0.10a1.4d1.3m0.0
	 */
	public String getMailFrom() {
		return mailFrom;
	}

	/**
	 * Description: setter for mailFrom variable
	 *
	 * @param mailFrom - email address FROM
	 * @since w0.10a1.4d1.3m0.0
	 */
	public void setMailFrom(String mailFrom) {
		this.mailFrom = mailFrom;
	}

	/**
	 * Description: getter for mailTo variable
	 *
	 * @return String - value of mailTo variable
	 * @since w0.10a1.4d1.3m0.0
	 */
	public String getMailTo() {
		return mailTo;
	}

	/**
	 * Description: setter for mailTo variable
	 *
	 * @param mailTo - email address TO
	 * @since w0.10a1.4d1.3m0.0
	 */
	public void setMailTo(String mailTo) {
		this.mailTo = mailTo;
	}

	/**
	 * Description: getter for mailSubject variable
	 *
	 * @return String - value of mailSubject variable
	 * @since w0.10a1.4d1.3m0.0
	 */
	public String getMailSubject() {
		return mailSubject;
	}

	/**
	 * Description: setter for mailSubject variable
	 *
	 * @param mailSubject - text of subject in mails
	 * @since w0.10a1.4d1.3m0.0
	 */
	public void setMailSubject(String mailSubject) {
		this.mailSubject = mailSubject;
	}

	/**
	 * Description: getter for mailContent variable
	 *
	 * @return String - value of mailContent variable
	 * @since w0.10a1.4d1.3m0.0
	 */
	public String getMailContent() {
		return mailContent;
	}

	/**
	 * Description: setter for mailContent variable
	 *
	 * @param mailContent - text of mails
	 * @since w0.10a1.4d1.3m0.0
	 */
	public void setMailContent(String mailContent) {
		this.mailContent = mailContent;
	}

	/**
	 * Description: getter for contentType variable
	 *
	 * @return String - value of contentType variable
	 * @since w0.10a1.4d1.3m0.0
	 */
	public String getContentType() {
		return contentType;
	}

	/**
	 * Description: setter for contentType variable
	 *
	 * @param contentType - type of text in mails
	 * @since w0.10a1.4d1.3m0.0
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	/**
	 * Description: simple toString() method in default implementation
	 *
	 * @return String - string view of instance
	 * @author Denys Shabelnyk
	 * @since w0.10a1.4d1.3m0.0
	 */
	@Override
	public String toString() {
		return "Mail [mailFrom=" + mailFrom + ", mailTo=" + mailTo + ", mailSubject=" + mailSubject + ", mailContent="
				+ mailContent + ", contentType=" + contentType + "]";
	}
}