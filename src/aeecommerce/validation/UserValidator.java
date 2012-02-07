package aeecommerce.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import aeecommerce.pojo.User;
import aeecommerce.service.UserService;

@Component
public class UserValidator implements Validator{

	@Autowired
	UserService userService;
	
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
		RegistrationInfo regInfo = (RegistrationInfo) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "username.required");
		
		// Altrimento estrapolo le informazione che mi servono e controllo se già esiste
		User user = new User( regInfo.getUsername(), null, null );
		System.out.println("Check existence " + user);
		User userDB = userService.findByUsername(user.getUsername());
		System.out.println(user);
		System.out.println(userDB);
		if(userDB != null )
			errors.rejectValue("username", "username.exists");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "confirmPassword.required");
		
		if(!regInfo.getPassword().equals(regInfo.getConfirmPassword()))
			errors.rejectValue("confirmPassword", "confirmPassword.different");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmEmail", "confirmEmail.required");
		
		if(!regInfo.getEmail().equals(regInfo.getConfirmEmail()))
			errors.rejectValue("confirmEmail", "confirmEmail.different");
		
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
