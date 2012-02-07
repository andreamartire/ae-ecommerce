package aeecommerce.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import aeecommerce.pojo.Indirizzo;
import aeecommerce.service.UserService;

@Controller
@SessionAttributes("userId")
public class AddressController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value={"/addAddress.htm"}, method = RequestMethod.GET)
	public String addressForm(@ModelAttribute("indirizzo") Indirizzo ind, BindingResult result, ModelMap model)
	{
		System.out.println("Address controller get");
		model.addAttribute("indirizzo", new Indirizzo());
		System.out.println(model);
		return "addAddress";
	}
	
	@RequestMapping(value={"/addAddress.htm"}, method = RequestMethod.POST)
	public String addAddress(@ModelAttribute("indirizzo") Indirizzo ind, BindingResult result, ModelMap model)
	{
		System.out.println("Address controller post");
		
		return "addAddress";
	}
}
