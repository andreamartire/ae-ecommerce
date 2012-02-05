package aeecommerce.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import aeecommerce.pojo.User;

@Component
public class UserValidator implements Validator{

	@Autowired
	PrivatoValidator privatoValidator;
	
	@Autowired
	AziendaValidator aziendaValidator;
	
	@Override
	public boolean supports(Class<?> c) {
		return User.class.isAssignableFrom(c);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "username.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "confirmPassword.required");
		RegistrationInfo regInfo = (RegistrationInfo) target;
		if(!regInfo.getPassword().equals(regInfo.getConfirmPassword()))
			errors.rejectValue("confirmPassword", "confirmPassword.different");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "type", "type.required");
		System.out.println("type: " + regInfo.getType());
		if(regInfo.getType() != null){
			if(regInfo.getType().equals("Privato"))
				privatoValidator.validate(target, errors);
			if(regInfo.getType().equals("Azienda"))
				aziendaValidator.validate(target, errors);
		}
	}

}
