package aeecommerce.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import aeecommerce.pojo.User;
import aeecommerce.service.UserService;

@Controller
@RequestMapping("/ajaxLogin.htm")
public class AjaxLoginController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody String ajaxLogin(@RequestParam String username, @RequestParam String password) {
		
		User userDB = userService.findByUsername(username);
		System.out.println(userDB);
		if(userDB == null)
			return "noUser";
		if(!userDB.getPassword().equals(password))
			return "badPassword";
		
		String result = "Bentornato " + userDB.getUsername();
		return result;
	}
}