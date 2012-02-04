package aeecommerce.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import aeecommerce.pojo.User;
import aeecommerce.service.UserService;


@Controller
@RequestMapping("/registration.htm")
public class RegistrationController {
	
	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String registrationForm(ModelMap model)
	{
		User user = new User();
		model.addAttribute("user", user);
		System.out.println("initialize user for registration form");
		return "registration";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String registrateUser(@ModelAttribute("user") User user, ModelMap model)
	{
		System.out.println("Check existence " + user);
		User userDB = userService.findByUsername(user.getUsername());
		System.out.println(user);
		System.out.println(userDB);
		if(userDB != null )
			return "userAlreadyExists";
		userService.insert(user);
		System.out.println("added user in to db " + user);
		return "userCreated";
	}
}