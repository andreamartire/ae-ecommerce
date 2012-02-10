package aeecommerce.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import aeecommerce.pojo.Azienda;
import aeecommerce.pojo.Privato;
import aeecommerce.pojo.User;
import aeecommerce.service.UserService;

@Controller
@SessionAttributes(value = {"user","type"})
public class GestioneDatiUtenteController {

	@Autowired
	UserService userService;
	 
	@RequestMapping(value={"/gestioneDatiUtente.htm"}, method = RequestMethod.GET)
	public String addressForm(@ModelAttribute("user") String username, ModelMap model)
	{
		System.out.println("dati utente controller get");
		if(userService.isPrivato(username))
			return "redirect:gestioneDatiPrivato.htm";
		return "redirect:gestioneDatiAzienda.htm";
	}
}