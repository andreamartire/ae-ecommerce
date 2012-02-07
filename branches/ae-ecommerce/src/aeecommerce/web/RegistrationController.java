package aeecommerce.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import aeecommerce.pojo.Azienda;
import aeecommerce.pojo.Indirizzo;
import aeecommerce.pojo.Privato;
import aeecommerce.service.AziendaService;
import aeecommerce.service.PrivatoService;
import aeecommerce.service.UserService;
import aeecommerce.validation.RegistrationInfo;
import aeecommerce.validation.UserValidator;


@Controller
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
			// Se è un privato registro un privato
			if(regInfo.getType().equals("Privato")){
				Privato pvt = regInfo.newPrivato();
				privatoService.insert(pvt);
				System.out.println("added privato in to db " + pvt);
				model.addAttribute("userId", userService.findByUsername(pvt.getUsername()).getId());
			}
			// Se è un'azienda registro un'azienda
			if(regInfo.getType().equals("Azienda")){
				Azienda az = regInfo.newAzienda();
				aziendaService.insert(az);
				System.out.println("added azienda in to db " + az);
				model.addAttribute("userId", userService.findByUsername(az.getUsername()).getId());
			}
			System.out.println("----------------------------------");
			
			model.addAttribute("indirizzo", new Indirizzo());
			return "redirect:addAddress.htm";
		}
	}
}