package aeecommerce.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import aeecommerce.pojo.Indirizzo;

@Controller
@RequestMapping("/addAddress.htm")
public class AddressController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String addAddress(ModelMap model)
	{
		System.out.println("Address controller get");
		return "home";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String addAddress(@ModelAttribute("indirizzo") Indirizzo indirizzo, BindingResult result, ModelMap model)
	{
		System.out.println("Address controller post");
		System.out.println("userId" + model.get("userId"));
		System.out.println("via" + model.get("via"));
		return "home";
	}
}