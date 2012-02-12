package aeecommerce.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import aeecommerce.pojo.Azienda;
import aeecommerce.pojo.Privato;
import aeecommerce.pojo.User;
import aeecommerce.service.UserService;

@Controller
@SessionAttributes(value = {"user","type","users","go"})
public class UserController {

	@Autowired
	private UserService userService;
	
	// User
	
	@RequestMapping(value = "/ajaxLogin.htm", method = RequestMethod.POST)
	public @ResponseBody String ajaxLogin(@RequestParam String username, @RequestParam String password, ModelMap model) {
		
		User userDB = userService.findByUsername(username);
		System.out.println(userDB);
		if(userDB == null)
			return "noUser";
		if(!userDB.getPassword().equals(password))
			return "badPassword";
		
		String name, type;
		if (userDB instanceof Privato)
			type = "privato";
		else if (userDB instanceof Azienda)
			type = "azienda";
		else
			type = "admin";
		name = username;
		
		model.addAttribute("user", name);
		model.addAttribute("type", type);
		
		String result = "Bentornato " + userDB.getUsername();
		return result;
	}
	
	@RequestMapping(value = "/logout.htm", method = RequestMethod.GET)
	public @ResponseBody String logout(ModelMap model) {
		String user = (String) model.get("user");
		model.put("user", "");
		return user;
	}
	
	@RequestMapping(value = {"/checkUsername.htm"}, method = RequestMethod.POST)
	public @ResponseBody String ajaxCheckUsername(@RequestParam String username, ModelMap model) {
		
		User userDB = userService.findByUsername(username);
		System.out.println(userDB);
		if(userDB == null)
			return "available";
		return "notAvailable";
	}
}