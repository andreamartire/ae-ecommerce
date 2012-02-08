package aeecommerce.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import aeecommerce.pojo.Azienda;
import aeecommerce.pojo.Indirizzo;
import aeecommerce.pojo.Privato;
import aeecommerce.pojo.User;
import aeecommerce.service.AziendaService;
import aeecommerce.service.PrivatoService;
import aeecommerce.service.UserService;
import aeecommerce.validation.RegistrationInfo;
import aeecommerce.validation.UserValidator;


@Controller
@SessionAttributes("userId")
public class RegistrationController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private PrivatoService privatoService;
	
	@Autowired
	private AziendaService aziendaService;

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

	@RequestMapping(value={"/registration.htm"}, method = RequestMethod.POST)
	public String registrateUser(
			@ModelAttribute("registrationInfo") RegistrationInfo regInfo, BindingResult result, ModelMap model)
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
			// Se è un privato registro un privato
			if(regInfo.getType().equals("Privato")){
				u = regInfo.newPrivato();
				privatoService.insert((Privato) u);
				System.out.println("added privato in to db " + u);
				
			}
			// Se è un'azienda registro un'azienda
			if(regInfo.getType().equals("Azienda")){
				u = regInfo.newAzienda();
				aziendaService.insert((Azienda) u);
				System.out.println("added azienda in to db " + u);
			}
			System.out.println("----------------------------------");
			model.addAttribute("user", u.getUsername());
			model.addAttribute("indirizzo", new Indirizzo());
			return "redirect:addAddress.htm";
		}
	}
}