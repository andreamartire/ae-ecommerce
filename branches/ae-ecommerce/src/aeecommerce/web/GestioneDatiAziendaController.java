package aeecommerce.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import aeecommerce.pojo.Azienda;
import aeecommerce.pojo.Privato;
import aeecommerce.pojo.User;
import aeecommerce.service.UserService;

@Controller
@SessionAttributes(value = {"user","userInfo"})
public class GestioneDatiAziendaController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value={"/gestioneDatiAzienda.htm"}, method = RequestMethod.GET)
	public String addressForm(@ModelAttribute("user") String username, ModelMap model)
	{
		System.out.println("dati azienda controller post");
		model.addAttribute("userInfo", userService.findByUsername(username));
		return "gestioneDatiAzienda";
	}
	
	@RequestMapping(value={"/gestioneDatiAzienda.htm"}, method = RequestMethod.POST)
	public String addressForm(@ModelAttribute("userInfo") Azienda u, ModelMap model)
	{
		System.out.println("dati azienda controller post");
		System.out.println(u);
		userService.update(u);
		return "gestioneDatiSuccess";
	}
}