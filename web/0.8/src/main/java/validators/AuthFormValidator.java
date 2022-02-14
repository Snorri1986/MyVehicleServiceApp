// need test task 31
package validators;

import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

@Component
public class AuthFormValidator implements Validator {

	private final Integer minPasswordLength = 5;

	// need test task 31
	public Integer OK = 0;
	// ... //

	// need test task 31
	public static Integer errNullValueCode = -2;
	public static Integer errNotlatinLettersCode = -3;
	public static Integer errPasswordShortCode = -4;
	// ... //

	@Override
	public Integer chkByNull(String val) {
		if (val.isEmpty())
			return errNullValueCode;
		return OK;
	}

	@Override
	public Integer chlLatinLetters(String val) {
		boolean valid = val.matches("\\w+");
		if (!valid)
			return errNotlatinLettersCode;
		return OK;
	}

	@Override
	public Integer chkPassowrdLength(String val) {
		int strLength = val.length();
		if (strLength < minPasswordLength)
			return errPasswordShortCode;
		return OK;
	}

	// need test task 31
	public Integer validateProcess(MultiValueMap<String, String[]> formDataForChecking) {

		// need test task 31
		String login = null;
		String password = null;
		Integer validationResult;
		// ... //

		for (String formKeyIterator : formDataForChecking.keySet()) {
			// need test task 31
			login = formDataForChecking.toString();
			password = formDataForChecking.get(formKeyIterator).toString();
			// ... //
			// System.out.print("Key: " + formDataForChecking.toString());
			// System.out.println("Value: " +
			// formDataForChecking.get(formKeyIterator).toString());
		}

		// need test task 31
		validationResult = chkByNull(login);
		validationResult = chkByNull(password);
		validationResult = chlLatinLetters(login);
		validationResult = chkPassowrdLength(password);

		switch (validationResult) {
		case -2: {
			return errNullValueCode;
		}
		case -3: {
			return errNotlatinLettersCode;
		}
		case -4: {
			return errPasswordShortCode;
		}
		}
		return OK;

	}
	// ... //

}
// ... //
