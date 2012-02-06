package aeecommerce.web;

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
@RequestMapping("/ajaxLogin.htm")
@SessionAttributes("user")
public class AjaxLoginController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody String ajaxLogin(@RequestParam String username, @RequestParam String password, ModelMap model) {
		
		User userDB = userService.findByUsername(username);
		System.out.println(userDB);
		if(userDB == null)
			return "noUser";
		if(!userDB.getPassword().equals(password))
			return "badPassword";
		
		String name;
		if (userDB instanceof Privato) {
			name = ((Privato) userDB).getNome() + " " + ((Privato) userDB).getCognome();
		} else if (userDB instanceof Azienda) {
			name = ((Azienda) userDB).getRagioneSociale();
		} else {
			name = username;
		}
		model.addAttribute("user", name);
		
		String result = "Bentornato " + userDB.getUsername();
		return result;
	}
}