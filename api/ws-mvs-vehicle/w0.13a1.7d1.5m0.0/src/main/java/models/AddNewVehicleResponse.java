package models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Description: class-response of adding new vehicle
 *
 * @author Denys Shabelnyk
 * @since w0.13a1.7d1.5m0.0
 */
public class AddNewVehicleResponse {

	private Integer code;

	public AddNewVehicleResponse() {

	}

	public AddNewVehicleResponse(Integer code) {
		this.code = code;
	}

	/**
	 * Description: code answer getter
	 *
	 * @author Denys Shabelnyk
	 * @return Integer value of answer
	 * @since w0.13a1.7d1.5m0.0
	 */
	@JsonProperty("code")
	public Integer getCode() {
		return code;
	}

	/**
	 * Description: code answer setter
	 *
	 * @author Denys Shabelnyk
	 * @param code value of code
	 * @since w0.13a1.7d1.5m0.0
	 */
	public void setCode(Integer code) {
		this.code = code;
	}

	/**
	 * Description: simple toString() method in default implementation
	 *
	 * @author Denys Shabelnyk
	 * @since w0.13a1.7d1.5m0.0
	 */
	@Override
	public String toString() {
		return "AddNewVehicleResponse [code=" + code + "]";
	}
}
