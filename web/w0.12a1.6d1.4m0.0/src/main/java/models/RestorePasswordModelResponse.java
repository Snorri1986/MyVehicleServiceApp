package models;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Description: class for mapping response of restore password
 *
 * @author Denys Shabelnyk
 * @since w0.10a1.4d1.3m0.0
 */
@Component
public class RestorePasswordModelResponse {

	private Integer code;

	public RestorePasswordModelResponse() {
		super();
	}

	public RestorePasswordModelResponse(Integer code) {
		super();
		this.code = code;
	}

	/**
	 * Description: getter for local variable "code"
	 *
	 * @author Denys Shabelnyk
	 * @return Integer value of answer code
	 * @since w0.10a1.4d1.3m0.0
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
	 * @since w0.10a1.4d1.3m0.0
	 */
	public void setCode(Integer code) {
		this.code = code;
	}

	/**
	 * Description: simple toString() method in default implementation
	 *
	 * @author Denys Shabelnyk
	 * @since w0.10a1.4d1.3m0.0
	 */
	@Override
	public String toString() {
		return "RestorePasswordModelResponse [code=" + code + "]";
	}

}