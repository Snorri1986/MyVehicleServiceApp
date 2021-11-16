// need test v0.5
package models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Description: The register response model class
 *
 * @author Denys Shabelnyk
 * @since 0.5
 */
public class RegisterResponseModel {
	private Integer code;

	public RegisterResponseModel() {

	}

	public RegisterResponseModel(Integer code) {
		this.code = code;
	}

	/**
	 * Description: getter for local variable "code"
	 *
	 * @author Denys Shabelnyk
	 * @return Integer value of answer code
	 * @since 0.5
	 */
	@JsonProperty("code")
	public Integer getCode() {
		return code;
	}

	/**
	 * Description: setter for local variable "code"
	 *
	 * @author Denys Shabelnyk
	 * @return Integer value of answer code
	 * @since 0.5
	 */
	public void setCode(Integer code) {
		this.code = code;
	}

	/**
	 * Description: simple toString() method in default implementation
	 *
	 * @author Denys Shabelnyk
	 * @since 0.5
	 */
	@Override
	public String toString() {
		return "RegisterResponseModel [code=" + code + "]";
	}
}
// ... //
