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
public class AccountController {

	@Autowired
	UserService userService;
	 
	@RequestMapping(value={"/account.htm"}, method = RequestMethod.GET)
	public String addressForm(@ModelAttribute("user") String username, ModelMap model)
	{
		System.out.println("Account controller get");
		return "account";
	}
	
//	@RequestMapping(value={"/account.htm"}, method = RequestMethod.POST)
//	public String addressForm(@ModelAttribute("regInfo") RegistrationInfo regInfo, @ModelAttribute("user") String username, ModelMap model)
//	{
//		System.out.println("Account controller post");
//		User u = userService.findByUsername(username);
//		User userUpdated = regInfo.objByType();
//		
//		System.out.println("Update info");
//		return "redirect:home.htm";
//	}
//	
//	public RegistrationInfo getRegInfo(String username){
//		System.out.println("Get reg info");
//		User u = userService.findByUsername(username);
//		System.out.println("trovato utente " + u);
//		if(u.getClass() == Privato.class){
//			System.out.println("E' un privato");
//			return ((Privato)u).toRegInfo();
//		}
//		if(u.getClass() == Azienda.class){
//			System.out.println("E' un'azienda");
//			return ((Azienda)u).toRegInfo();
//		}
//		return null;
//	}
}