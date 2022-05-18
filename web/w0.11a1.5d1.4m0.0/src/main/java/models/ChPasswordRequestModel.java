package models;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Description: class for handling JSON model of change password request.
 *
 * @author Denys Shabelnyk
 * @since w0.11a1.5d1.4m0.0
 */
@Component
public class ChPasswordRequestModel {
	private String login;
	private String oldPassword;
	private String newPassword;
	private String passConfirmation;

	public ChPasswordRequestModel() {

	}

	public ChPasswordRequestModel(String login, String oldPassword, String newPassword, String passConfirmation) {
		this.login = login;
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
		this.passConfirmation = passConfirmation;
	}

	/**
	 * Description: getter for login variable
	 *
	 * @return String - value of login variable
	 * @since w0.11a1.5d1.4m0.0
	 */
	@JsonProperty("login")
	public String getLogin() {
		return login;
	}

	/**
	 * Description: setter for login variable
	 *
	 * @param login - new value of loginvarible
	 * @since w0.11a1.5d1.4m0.0
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * Description: getter for oldPassword variable
	 *
	 * @return String - value of oldPassword variable
	 * @since w0.11a1.5d1.4m0.0
	 */
	@JsonProperty("oldpass")
	public String getOldPassword() {
		return oldPassword;
	}

	/**
	 * Description: setter for oldPassword variable
	 *
	 * @param oldPassword - new value of oldPassword varible
	 * @since w0.11a1.5d1.4m0.0
	 */
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	/**
	 * Description: getter for newPassword variable
	 *
	 * @return String - value of newPassword variable
	 * @since w0.11a1.5d1.4m0.0
	 */
	@JsonProperty("newpass")
	public String getNewPassword() {
		return newPassword;
	}

	/**
	 * Description: setter for newPassword variable
	 *
	 * @param newPassword - new value of newPassword varible
	 * @since w0.11a1.5d1.4m0.0
	 */
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	/**
	 * Description: getter for passConfirmation variable
	 *
	 * @return String - value of passConfirmation variable
	 * @since w0.11a1.5d1.4m0.0
	 */
	public String getPassConfirmation() {
		return passConfirmation;
	}

	/**
	 * Description: setter for passConfirmation variable
	 *
	 * @param passConfirmation - new value of passConfirmation varible
	 * @since w0.11a1.5d1.4m0.0
	 */
	public void setPassConfirmation(String passConfirmation) {
		this.passConfirmation = passConfirmation;
	}

	/**
	 * Description: simple toString() method in default implementation
	 *
	 * @return String - string view of instance
	 * @author Denys Shabelnyk
	 * @since w0.11a1.5d1.4m0.0
	 */
	@Override
	public String toString() {
		return "ChPasswordRequestModel [login=" + login + ", oldPassword=" + oldPassword + ", newPassword="
				+ newPassword + "]";
	}
}