package aeecommerce.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import aeecommerce.pojo.User;

@Component
public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> c) {
		return User.class.isAssignableFrom(c);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "username.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.required");
	}

}
