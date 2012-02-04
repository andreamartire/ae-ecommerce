package aeecommerce.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import aeecommerce.pojo.User;
import aeecommerce.service.UserService;

@Controller
@RequestMapping("/login.htm")
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.POST)
	public String registrationForm(@ModelAttribute("user") User user, ModelMap model)
	{
		System.out.println("Check existence " + user);
		User userDB = userService.findByUsername(user.getUsername());
		System.out.println(user);
		System.out.println(userDB);
		if(userDB == null || !userDB.getPassword().equals(user.getPassword()) )
			return "loginFailed";
		return "userHome";
	}
}