package aeecommerce.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import aeecommerce.pojo.User;
import aeecommerce.service.UserService;

@Controller
@SessionAttributes("user")
public class AjaxLoginController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = {"/checkUsername.htm"}, method = RequestMethod.POST)
	public @ResponseBody String ajaxCheckUsername(@RequestParam String username, ModelMap model) {
		
		User userDB = userService.findByUsername(username);
		System.out.println(userDB);
		if(userDB == null)
			return "available";
		return "notAvailable";
	}
}