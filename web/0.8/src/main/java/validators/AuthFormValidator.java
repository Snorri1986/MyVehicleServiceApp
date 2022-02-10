// need test task 31
package validators;

import org.springframework.stereotype.Component;

@Component
public class AuthFormValidator implements Validator {

	private final Integer minPasswordLength = 5;

	public Integer errNullValueCode = -2;
	public Integer errNotlatinLettersCode = -3;
	public Integer errPasswordShortCode = -4;

	@Override
	public Integer chkByNull(String val) {
		if (val.equalsIgnoreCase("null"))
			return errNullValueCode;
		return null;
	}

	@Override
	public Integer chlLatinLetters(String val) {
		boolean valid = val.matches("\\w+");
		if (!valid)
			return errNotlatinLettersCode;
		return null;
	}

	@Override
	public Integer chkPassowrdLength(String val) {
		int strLength = val.length();
		if (strLength < minPasswordLength)
			return errPasswordShortCode;
		return null;
	}

}
// ... //
