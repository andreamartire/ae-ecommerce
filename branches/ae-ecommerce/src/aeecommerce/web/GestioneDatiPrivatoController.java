package aeecommerce.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import aeecommerce.pojo.Privato;
import aeecommerce.service.UserService;

@Controller
@SessionAttributes(value = {"user","userInfo"})
public class GestioneDatiPrivatoController {

	@Autowired
	UserService userService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}


	@RequestMapping(value={"/gestioneDatiPrivato.htm"}, method = RequestMethod.GET)
	public String addressForm(@ModelAttribute("user") String username, ModelMap model)
	{
		System.out.println("dati privato controller post");
		model.addAttribute("userInfo", userService.findByUsername(username));
		return "gestioneDatiPrivato";
	}

	@RequestMapping(value={"/gestioneDatiPrivato.htm"}, method = RequestMethod.POST)
	public String addressForm(@ModelAttribute("userInfo") Privato u, ModelMap model)
	{
		System.out.println("dati privato controller post");
		System.out.println(u);
		try {
			userService.update(u);
		}
		catch (Exception e) {
			return "gestioneDatiError";
		}
		return "gestioneDatiSuccess";
	}
}