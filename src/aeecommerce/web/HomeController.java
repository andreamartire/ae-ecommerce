package aeecommerce.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import aeecommerce.pojo.User;


@Controller
@RequestMapping("/home.htm")
public class HomeController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String getHome(ModelMap model)
	{
		User user = new User();
		model.addAttribute("user", user);
		System.out.println("HOME CONTROLLER GET");
		return "home";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String getLogin(ModelMap model)
	{
		System.out.println("Home controller post " + model.get("user"));
		return "login";
	}
//	
//	@Override
//	protected ModelAndView onSubmit(Object command) {
//		User user = (User) command;
//		System.out.println("Home controller on submit " + user);
//		return new ModelAndView("userSuccess","user",user);
//	}
}