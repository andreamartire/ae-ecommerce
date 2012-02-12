package aeecommerce.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import aeecommerce.pojo.Amministratore;
import aeecommerce.service.UserService;


@Controller
@RequestMapping("/home.htm")
public class HomeController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getHome(ModelMap model)
	{
		Amministratore admin = new Amministratore();
		admin.setUsername("admin");
		admin.setPassword("admin");
		if (userService.findByUsername("admin") == null) {
			userService.insert(admin);
		}
		
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