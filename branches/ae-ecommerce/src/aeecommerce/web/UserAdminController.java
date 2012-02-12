package aeecommerce.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import aeecommerce.pojo.User;
import aeecommerce.service.UserService;

@Controller
@SessionAttributes(value = {"user","type","users","go","userInfo"})
public class UserAdminController {

	@Autowired
	private UserService userService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	@RequestMapping(value = {"/gestioneUtenti.htm"}, method = RequestMethod.GET)
	public String listUsers(ModelMap model) {
		List<User> users = userService.findAll();
        model.put("users", users);
        
        return "userManagement";
	}
	
	@RequestMapping(value = {"/modificaUtente.htm"}, method = RequestMethod.GET)
	public String modifyUserGet(@RequestParam int id, ModelMap model) {
		System.out.println("Modifica utente " + id + " get");
		User userDB = userService.findById(id);
		model.addAttribute("userInfo", userDB);
		if(userService.isPrivato(userDB.getUsername()))
			return "gestioneAdminDatiPrivato";
		return "gestioneAdminDatiAzienda";
	}
	
	@RequestMapping(value={"/modificaUtente.htm"}, method = RequestMethod.POST)
	public String gestioneDatiPrivatoPost(@ModelAttribute("userInfo") User u, ModelMap model)
	{
		System.out.println("gestione utente admin post");
		System.out.println(u);
		try {
			userService.update(u);
		}
		catch (Exception e) {
			return "gestioneAdminDatiError";
		}
		return "gestioneAdminDatiSuccess";
	}
	
	@RequestMapping(value = {"/eliminaUtente.htm"}, method = RequestMethod.GET)
	public String deleteUser(@RequestParam int id) {
		userService.delete(id);
		return "redirect:gestioneUtenti.htm";
	}
}