package models;

import org.springframework.stereotype.Component;

/**
 * Description: Change password response model
 *
 * @author Denys Shabelnyk
 * @since w0.11a1.5d1.4m0.0
 */
@Component
public class ChPasswordResponseModel {
	private Integer code;

	public ChPasswordResponseModel() {
		super();
	}

	public ChPasswordResponseModel(Integer code) {
		super();
		this.code = code;
	}

	/**
	 * Description: getter for code variable
	 *
	 * @return Integer - value of code variable
	 * @since w0.11a1.5d1.4m0.0
	 */
	public Integer getCode() {
		return code;
	}

	/**
	 * Description: setter for code variable
	 *
	 * @param code - new value of code varible
	 * @since w0.11a1.5d1.4m0.0
	 */
	public void setCode(Integer code) {
		this.code = code;
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
		return "ChPasswordResponseModel [code=" + code + "]";
	}
}