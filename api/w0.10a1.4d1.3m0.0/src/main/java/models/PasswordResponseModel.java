package models;

/**
 * Description: The password response model class in restore password process
 *
 * @author Denys Shabelnyk
 * @since w0.10a1.4d1.3m0.0
 */
public class PasswordResponseModel {

	private Integer code;

	public PasswordResponseModel() {

	}

	public PasswordResponseModel(Integer code) {
		this.code = code;
	}

	/**
	 * Description: code getter
	 *
	 * @author Denys Shabelnyk
	 * @return Integer value of login variable
	 * @since w0.10a1.4d1.3m0.0
	 */
	public Integer getCode() {
		return code;
	}

	/**
	 * Description: code getter
	 *
	 * @author Denys Shabelnyk
	 * @param code value of login variable
	 * @since w0.10a1.4d1.3m0.0
	 */
	public void setCode(Integer code) {
		this.code = code;
	}

	/**
	 * Description: simple toString() method in default implementation
	 *
	 * @return String - string view of instance
	 * @author Denys Shabelnyk
	 * @since w0.10a1.4d1.3m0.0
	 */
	@Override
	public String toString() {
		return "PasswordResponseModel [code=" + code + "]";
	}

}