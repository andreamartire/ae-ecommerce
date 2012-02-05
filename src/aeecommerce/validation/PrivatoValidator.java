package aeecommerce.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import aeecommerce.pojo.Privato;

@Component
public class PrivatoValidator implements Validator{

	@Override
	public boolean supports(Class<?> c) {
		return Privato.class.isAssignableFrom(c);
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("Privato validation");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "codiceFiscale", "cf.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dataNascita", "dataNascita.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "luogoNascita", "username.required");

	}

}
