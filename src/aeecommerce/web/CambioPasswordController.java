package aeecommerce.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import aeecommerce.pojo.User;
import aeecommerce.service.UserService;
import aeecommerce.validation.RegistrationInfo;

@Controller
@SessionAttributes(value ={"info","user"})
public class CambioPasswordController {

	@Autowired
	UserService userService;
	 
	@RequestMapping(value={"/changePassword.htm"}, method = RequestMethod.GET)
	public String changePasswordForm(@ModelAttribute("user") String username, ModelMap model)
	{
		System.out.println("Change password controller get");
		model.addAttribute("info", new RegistrationInfo());
		return "changePassword";
	}
	
	@RequestMapping(value={"/changePassword.htm"}, method = RequestMethod.POST)
	public String changePassord(@ModelAttribute("info") RegistrationInfo info, @ModelAttribute("user") String username)
	{
		System.out.println("Change password controller post");
		User u = userService.findByUsername(username);
		if(info.getPassword().equals(u.getPassword())){
			u.setPassword(info.getConfirmPassword());
			userService.update(u);
		}
		else
			return "redirect:passwordError.htm";
		System.out.println("Updated password");
		return "redirect:passwordSuccess.htm";
	}
	
	@RequestMapping(value={"/passwordSuccess.htm"}, method = RequestMethod.GET)
	public String passwordSuccess(){
		return "passwordSuccess";
	}
	
	@RequestMapping(value={"/passwordError.htm"}, method = RequestMethod.GET)
	public String passwordError(){
		return "passwordError";
	}
}