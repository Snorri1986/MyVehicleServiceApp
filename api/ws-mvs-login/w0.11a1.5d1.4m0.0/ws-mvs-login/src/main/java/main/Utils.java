package main;

import java.util.Base64;

/**
 * Description: class for storing helper methods
 *
 * @author Denys Shabelnyk
 * @since 1.0
 */
public class Utils {

	public static final String positiveAnswer = "0";
	public static final String negativeAnswer = "-1";

	/**
	 * Description: The method hashing string value and returns it on base64
	 *
	 * @param valueToEncoded string value for decoding
	 * @return String decoded message
	 * @since 1.0
	 */
	public static String getBase64HashPhrase(String valueToEncoded) {
		return Base64.getEncoder().encodeToString(valueToEncoded.getBytes());
	}
}
