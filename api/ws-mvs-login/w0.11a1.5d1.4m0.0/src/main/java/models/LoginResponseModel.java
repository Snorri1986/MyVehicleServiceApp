package models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Description: class-response of authorization request
 *
 * @author Denys Shabelnyk
 * @since 0.6
 */
public class LoginResponseModel {
	private Integer code;

	public LoginResponseModel() {

	}

	public LoginResponseModel(Integer code) {
		this.code = code;
	}

	/**
	 * Description: getter for local variable "code"
	 *
	 * @author Denys Shabelnyk
	 * @return Integer value of answer code
	 * @since 0.6
	 */
	@JsonProperty("code")
	public Integer getCode() {
		return code;
	}

	/**
	 * Description: setter for local variable "code"
	 *
	 * @param code - Integer value of response code
	 * @author Denys Shabelnyk
	 * @since 0.6
	 */
	public void setCode(Integer code) {
		this.code = code;
	}

	/**
	 * Description: simple toString() method in default implementation
	 *
	 * @author Denys Shabelnyk
	 * @since 0.6
	 */
	@Override
	public String toString() {
		return "LoginResponseModel [code=" + code + "]";
	}

}
