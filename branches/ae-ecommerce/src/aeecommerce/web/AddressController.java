package aeecommerce.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import aeecommerce.pojo.Indirizzo;
import aeecommerce.pojo.User;
import aeecommerce.service.UserService;

@Controller
@SessionAttributes(value = "indirizzo" )
public class AddressController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value={"/addAddress.htm"}, method = RequestMethod.GET)
	public String addressForm(ModelMap model)
	{
		System.out.println("Address controller get");
		model.addAttribute("indirizzo", new Indirizzo());
		return "addAddress";
	}
	
	@RequestMapping(value={"/addAddress.htm"}, method = RequestMethod.POST)
	public String addAddress(@ModelAttribute("indirizzo") Indirizzo ind, @ModelAttribute("user") String username)
	{
		System.out.println("Address controller post");
		System.out.println("user " + username);
		System.out.println("Indirizzo " + ind);
		User user = userService.findByUsername(username);
		user.addIndirizzo(ind);
		userService.update(user);
		return "redirect:home.htm";
	}
}
