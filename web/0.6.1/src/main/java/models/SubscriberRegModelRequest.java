package models;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Denys Shabelnyk Description: Class model for new subscriber
 *
 */
@Component
public class SubscriberRegModelRequest {
	private String username;
	private String password;
	private String firstname;
	private String lastname;

	public SubscriberRegModelRequest() {

	}

	public SubscriberRegModelRequest(String username, String password, String firstname, String lastname) {
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	/**
	 * Description: username getters
	 *
	 * @author Denys Shabelnyk
	 * @return String value of username variable
	 * @since 0.4
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
	 * @since 0.4
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Description: password getter
	 *
	 * @author Denys Shabelnyk
	 * @return String value of password variable
	 * @since 0.4
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
	 * @since 0.4
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Description: first name of user getter
	 *
	 * @author Denys Shabelnyk
	 * @return String value of first name
	 * @since 0.4
	 */
	@JsonProperty("fname")
	public String getFirstname() {
		return firstname;
	}

	/**
	 * Description: first name of user setter
	 *
	 * @author Denys Shabelnyk
	 * @param firstname value of first name
	 * @since 0.4
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * Description: last name of user getter
	 *
	 * @author Denys Shabelnyk
	 * @return String value of last name
	 * @since 0.4
	 */
	@JsonProperty("lname")
	public String getLastname() {
		return lastname;
	}

	/**
	 * Description: last name of user setter
	 *
	 * @author Denys Shabelnyk
	 * @param lastname value of last name
	 * @since 0.4
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * Description: simple toString() method in default implementation
	 *
	 * @author Denys Shabelnyk
	 * @since 0.4
	 */
	@Override
	public String toString() {
		return "SubscriberRegModelRequest [username=" + username + ", password=" + password + ", firstname=" + firstname
				+ ", lastname=" + lastname + "]";
	}
}