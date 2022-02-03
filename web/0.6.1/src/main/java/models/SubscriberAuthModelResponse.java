package models;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class SubscriberAuthModelResponse {
	private Integer code;

	public SubscriberAuthModelResponse() {
	}

	public SubscriberAuthModelResponse(Integer code) {
		this.code = code;
	}

	/**
	 * Description: getter for local variable "code"
	 *
	 * @author Denys Shabelnyk
	 * @return Integer value of answer code
	 * @since 0.7
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
	 * @since 0.7
	 */
	public void setCode(Integer code) {
		this.code = code;
	}

	/**
	 * Description: simple toString() method in default implementation
	 *
	 * @author Denys Shabelnyk
	 * @since 0.7
	 */
	@Override
	public String toString() {
		return "LoginResponseModel [code=" + code + "]";
	}
}
