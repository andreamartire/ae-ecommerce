package aeecommerce.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import aeecommerce.pojo.User;
import aeecommerce.service.UserService;
import aeecommerce.validation.RegistrationInfo;
import aeecommerce.validation.UserValidator;


@Controller
@SessionAttributes(value = {"reguser"})
public class RegistrationController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserValidator userValidator;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String registrationForm(ModelMap model)
	{
		// Aggiungo oggetto intermedio per raccogliere info sulla registrazione
		System.out.println("Registration controller get");
		model.addAttribute("registrationInfo", new RegistrationInfo());

		System.out.println("initialize user for registration form");
		System.out.println("----------------------------------");
		return "registration";
	}

	@RequestMapping(value={"/registration.htm"}, method = RequestMethod.POST)
	public String registrateUser(@ModelAttribute("registrationInfo") RegistrationInfo regInfo, BindingResult result, ModelMap model)
	{
		System.out.println("Registration controller post");

		// Applico validazione alle info recuperate
		userValidator.validate(regInfo, result);
		if (result.hasErrors()){
			System.out.println("Presenti errori in fase di validazione");
			// Se fallisce la validazione rimando indietro l'oggetto alla jsp
			return "registration";
		}
		else {
			User u = null;
			
			if(regInfo.getType().equals("Privato")){
				u = regInfo.toPrivato();
				System.out.println("adding privato in to db " + u);
				
			} else if(regInfo.getType().equals("Azienda")){
				u = regInfo.toAzienda();
				System.out.println("adding azienda in to db " + u);
				
			} else {
				System.out.println("?????? che user e'?");
			}
			userService.insert(u);
			System.out.println("----------------------------------");
			
			model.put("reguser", regInfo.getUsername());
			model.addAttribute("name", regInfo.getNome());
			
			return "redirect:aggiungiIndirizzo.htm";
		}
	}
}