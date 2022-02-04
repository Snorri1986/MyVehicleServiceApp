package models;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Description: class model for registration process response
 *
 * @author Denys Shabelnyk
 */
@Component
public class SubscriberRegModelResponse {
	private Integer code;

	public SubscriberRegModelResponse() {
	}

	public SubscriberRegModelResponse(Integer code) {
		this.code = code;
	}

	/**
	 * Description: getter for local variable "code"
	 *
	 * @author Denys Shabelnyk
	 * @return Integer value of answer code
	 * @since 0.6.1
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
	 * @since 0.6.1
	 */
	public void setCode(Integer code) {
		this.code = code;
	}

	/**
	 * Description: simple toString() method in default implementation
	 *
	 * @author Denys Shabelnyk
	 * @since 0.6.1
	 */
	@Override
	public String toString() {
		return "RegisterResponseModel [code=" + code + "]";
	}
}
