package aeecommerce.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import aeecommerce.pojo.Azienda;
import aeecommerce.pojo.Privato;
import aeecommerce.service.AziendaService;
import aeecommerce.service.PrivatoService;
import aeecommerce.validation.RegistrationInfo;

@Controller
@SessionAttributes(value = {"user","regInfo"})
public class AccountController {

	@Autowired
	PrivatoService privatoService;
	
	@Autowired
	AziendaService aziendaService;
	 
	@RequestMapping(value={"/account.htm"}, method = RequestMethod.GET)
	public String addressForm(@ModelAttribute("user") String username, ModelMap model)
	{
		System.out.println("Account controller get");
		model.addAttribute("regInfo", getRegInfo(username));
		return "account";
	}
	
	@RequestMapping(value={"/account.htm"}, method = RequestMethod.POST)
	public String addressForm(@ModelAttribute("regInfo") RegistrationInfo regInfo, ModelMap model)
	{
		System.out.println("Account controller post");
		System.out.println("Update info");
		return "redirect:home.htm";
	}
	
	public RegistrationInfo getRegInfo(String username){
		System.out.println("Get reg info");
		Privato pvt = privatoService.findByUsername(username);
		if(pvt != null){
			System.out.println("E' un privato");
			return pvt.toRegInfo();
		}
		Azienda az = aziendaService.findByUsername(username);
		if(az != null) {
			System.out.println("E' un'azienda");
			return az.toRegInfo();
		}
		return null;
	}
}