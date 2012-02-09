package aeecommerce.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import aeecommerce.service.UserService;

@Controller
@SessionAttributes(value = {"user","regInfo"})
public class DatiUtenteController {

	@Autowired
	UserService userService;
	 
	@RequestMapping(value={"/gestioneDatiUtente.htm"}, method = RequestMethod.GET)
	public String addressForm(@ModelAttribute("user") String username, ModelMap model)
	{
		System.out.println("dati utente controller get");
		return "gestioneDatiUtente";
	}
}