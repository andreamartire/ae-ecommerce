package aeecommerce.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/logout.htm")
@SessionAttributes("user")
public class LogoutController {

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody String logout(ModelMap model) {
		String user = (String) model.get("user");
		model.put("user", "");
		return user;
	}
}
