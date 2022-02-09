// need test task 31
package validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import models.SubscriberAuthModelRequest;

@Component
public class AuthFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return SubscriberAuthModelRequest.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		SubscriberAuthModelRequest authRequest = (SubscriberAuthModelRequest) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty.authForm.username");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.authForm.password");

		if (authRequest.getUsername().equalsIgnoreCase(null)) {
			errors.rejectValue("username", "NotEmpty.authForm.username");
		}

		if (authRequest.getPassword().equalsIgnoreCase(null)) {
			errors.rejectValue("password", "NotEmpty.authForm.password");
		}

	}

}
// ... //
