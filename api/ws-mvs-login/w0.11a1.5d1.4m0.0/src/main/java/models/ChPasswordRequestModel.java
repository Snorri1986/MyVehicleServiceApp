package models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Description: Change password request model
 *
 * @author Denys Shabelnyk
 * @since w0.11a1.5d1.4m0.0
 */
public class ChPasswordRequestModel {
	private String login;
	private String oldPassword;
	private String newPassword;

	public ChPasswordRequestModel() {

	}

	public ChPasswordRequestModel(String login, String oldPassword, String newPassword) {
		this.login = login;
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
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
	 * @param login - new value of login variable
	 * @since w0.11a1.5d1.4m0.0
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * Description: getter for oldpassword variable
	 *
	 * @return String - value of oldpassword variable
	 * @since w0.11a1.5d1.4m0.0
	 */
	@JsonProperty("oldpass")
	public String getOldPassword() {
		return oldPassword;
	}

	/**
	 * Description: setter for oldpassword variable
	 *
	 * @param oldPassword - new value of oldPassword variable
	 * @since w0.11a1.5d1.4m0.0
	 */
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	/**
	 * Description: getter for newpassword variable
	 *
	 * @return String - value of newpassword variable
	 * @since w0.11a1.5d1.4m0.0
	 */
	@JsonProperty("newpass")
	public String getNewPassword() {
		return newPassword;
	}

	/**
	 * Description: setter for newPassword variable
	 *
	 * @param newPassword - new value of newPassword variable
	 * @since w0.11a1.5d1.4m0.0
	 */
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
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