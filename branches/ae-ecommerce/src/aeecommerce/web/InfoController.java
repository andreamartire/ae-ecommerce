package aeecommerce.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import aeecommerce.service.UserService;


@Controller
public class InfoController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value={"/gestioneInfoOLD.htm"}, method = RequestMethod.GET)
	public String getInfo(@ModelAttribute("user") String user)
	{
		System.out.println("Gestione Info get user " + user);
		return "adminInfo";
	}
}