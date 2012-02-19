package aeecommerce.web;

import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import aeecommerce.pojo.Indirizzo;
import aeecommerce.pojo.User;
import aeecommerce.service.IndirizzoService;
import aeecommerce.service.UserService;

@Controller
@SessionAttributes(value = {"userdb", "indirizzo"})
public class IndirizziController {

	@Autowired
	UserService userService;
	
	@Autowired
	IndirizzoService indirizzoService;
	
	@RequestMapping(value="/gestioneIndirizzi.htm", method = RequestMethod.GET)
	public String addressFormGet(ModelMap model, HttpSession session)
	{
		System.out.println("gestione indirizzi controller get");
		
		String username = (String) session.getAttribute("user");
		
		Set<Indirizzo> indirizzi = userService.findByUsername(username).getIndirizzi();
		for (Indirizzo indirizzo : indirizzi) {
			System.out.println(indirizzo);
		}
		
		model.put("userdb",userService.findByUsername(username));
		
		return "gestioneIndirizzi";
	}

	@RequestMapping(value="/gestioneIndirizzi.htm", method = RequestMethod.POST)
	public String addressFormPost(@ModelAttribute("userdb") User user, HttpSession session)
	{
		String username = (String) session.getAttribute("user");
		
		System.out.println("gestione indirizzi controller post");
		
		User u = userService.findByUsername(username);
		u.setIndirizzi(user.getIndirizzi());
		userService.update(u);
		
		Set<Indirizzo> indirizzi = userService.findByUsername(username).getIndirizzi();
		for (Indirizzo indirizzo : indirizzi) {
			System.out.println(indirizzo);
		}
		
		return "redirect:gestioneIndirizzi.htm";
	}
	
	@RequestMapping(value="/aggiungiIndirizzo.htm", method = RequestMethod.GET)
	public String addAddressGet(ModelMap model)
	{
		System.out.println("aggiungi indirizzo controller get");
		model.put("indirizzo", new Indirizzo());
		return "aggiungiIndirizzo";
	}
	
	@RequestMapping(value="/aggiungiIndirizzo.htm", method = RequestMethod.POST)
	public String addAddressPost(@ModelAttribute("indirizzo") Indirizzo indirizzo, HttpSession session)
	{
		String username = (String) session.getAttribute("user");
		
		User u = userService.findByUsername(username);
		u.getIndirizzi().add(indirizzo);
		userService.update(u);
		return "redirect:gestioneIndirizzi.htm";
	}
	
	@RequestMapping(value="/eliminaIndirizzo.htm")
	public String removeAddressGet(@RequestParam int idAddress)
	{
		indirizzoService.delete(idAddress);
		return "redirect:gestioneIndirizzi.htm";
	}
}