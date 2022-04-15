package models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Description: The password response model class in restore password process
 *
 * @author Denys Shabelnyk
 * @since w0.10a1.4d1.3m0.0
 */
public class PasswordResponseModel {

	private String hash;

	public PasswordResponseModel() {

	}

	public PasswordResponseModel(String hash) {
		this.hash = hash;
	}

	/**
	 * Description: hash getter
	 *
	 * @author Denys Shabelnyk
	 * @return String value of hash variable
	 * @since w0.10a1.4d1.3m0.0
	 */
	@JsonProperty("hash")
	public String getHash() {
		return hash;
	}

	/**
	 * Description: hash setter
	 *
	 * @author Denys Shabelnyk
	 * @param hash gets from internal JSON request
	 * @since w0.10a1.4d1.3m0.0
	 */
	public void setHash(String hash) {
		this.hash = hash;
	}

	/**
	 * Description: simple toString() method in default implementation
	 *
	 * @author Denys Shabelnyk
	 * @since w0.10a1.4d1.3m0.0
	 */
	@Override
	public String toString() {
		return "PasswordResponseModel [hash=" + hash + "]";
	}

}