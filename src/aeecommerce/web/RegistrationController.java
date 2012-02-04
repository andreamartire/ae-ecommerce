package aeecommerce.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import aeecommerce.pojo.User;
import aeecommerce.service.UserService;
import aeecommerce.validation.RegistrationInfo;
import aeecommerce.validation.UserValidator;


@Controller
@RequestMapping("/registration.htm")
public class RegistrationController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserValidator userValidator;

	@RequestMapping(method = RequestMethod.GET)
	public String registrationForm(ModelMap model)
	{
		// Aggiungo oggetto intermedio per raccogliere info sulla registrazione
		System.out.println("Registration controller get");
		RegistrationInfo uv = new RegistrationInfo();
		model.addAttribute("registrationInfo", uv);
		
		System.out.println("initialize user for registration form");
		System.out.println("----------------------------------");
		return "registration";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String registrateUser(
			@ModelAttribute("registrationInfo") RegistrationInfo regInfo, BindingResult result)
	{
		System.out.println("Registration controller post");
		
		// Applico validazione alle info recuperate
		userValidator.validate(regInfo, result);
		if (result.hasErrors())
			// Se fallisce la validazione rimando indietro l'oggetto alla jsp
			return "registration";
		else {
			// Altrimento estrapolo le informazione che mi servono e procedo
			User user = new User( regInfo.getUsername(), regInfo.getPassword(), null );
			System.out.println("Check existence " + user);
			User userDB = userService.findByUsername(user.getUsername());
			System.out.println(user);
			System.out.println(userDB);
			if(userDB != null )
				return "userAlreadyExists";
			userService.insert(user);
			System.out.println("added user in to db " + user);
			System.out.println("----------------------------------");
			return "userCreated";
		}
	}
}