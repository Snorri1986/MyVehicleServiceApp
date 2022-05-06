package models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Description: The password request model class in restore password process
 *
 * @author Denys Shabelnyk
 * @since w0.10a1.4d1.3m0.0
 */
public class PasswordRequestModel {

	private String login;
	private String email;

	public PasswordRequestModel() {

	}

	public PasswordRequestModel(String login, String email) {
		this.login = login;
		this.email = email;
	}

	/**
	 * Description: login getter
	 *
	 * @author Denys Shabelnyk
	 * @return String value of login variable
	 * @since w0.10a1.4d1.3m0.0
	 */
	@JsonProperty("login")
	public String getLogin() {
		return login;
	}

	/**
	 * Description: login setter
	 *
	 * @author Denys Shabelnyk
	 * @param login gets from internal JSON request
	 * @since w0.10a1.4d1.3m0.0
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * Description: email getter
	 *
	 * @author Denys Shabelnyk
	 * @return String value of email variable
	 * @since w0.10a1.4d1.3m0.0
	 */
	@JsonProperty("email")
	public String getEmail() {
		return email;
	}

	/**
	 * Description: email setter
	 *
	 * @author Denys Shabelnyk
	 * @param email gets from internal JSON request
	 * @since w0.10a1.4d1.3m0.0
	 */
	public void setEmail(String email) {
		this.email = email;
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
		return "PasswordRequestModel [login=" + login + ", email=" + email + "]";
	}
}