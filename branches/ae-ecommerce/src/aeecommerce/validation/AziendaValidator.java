package aeecommerce.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import aeecommerce.pojo.Azienda;

@Component
public class AziendaValidator implements Validator{

	@Override
	public boolean supports(Class<?> c) {
		return Azienda.class.isAssignableFrom(c);
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("Azienda validation");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "piva", "piva.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ragioneSociale", "rs.required");
	}

}

