package models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Description: The login request model class
 *
 * @author Denys Shabelnyk
 * @since 0.6
 */
public class LoginRequestModel {

	private String username;
	private String password;

	public LoginRequestModel() {

	}

	public LoginRequestModel(String login, String pass) {
		this.username = login;
		this.password = pass;
	}

	/**
	 * Description: username getter
	 *
	 * @author Denys Shabelnyk
	 * @return String value of username variable
	 * @since 0.6
	 */
	@JsonProperty("login")
	public String getUsername() {
		return username;
	}

	/**
	 * Description: username setter
	 *
	 * @author Denys Shabelnyk
	 * @param username gets from internal JSON request
	 * @since 0.6
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Description: password getter
	 *
	 * @author Denys Shabelnyk
	 * @return String value of password variable
	 * @since 0.6
	 */
	@JsonProperty("password")
	public String getPassword() {
		return password;
	}

	/**
	 * Description: password setter
	 *
	 * @author Denys Shabelnyk
	 * @param password value of password
	 * @since 0.6
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Description: simple toString() method in default implementation
	 *
	 * @author Denys Shabelnyk
	 * @since 0.6
	 */
	@Override
	public String toString() {
		return "LoginRequestModel [username=" + username + ", password=" + password + "]";
	}
}
