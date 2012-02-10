package aeecommerce.web;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import aeecommerce.pojo.Indirizzo;
import aeecommerce.pojo.User;
import aeecommerce.service.UserService;

@Controller
@SessionAttributes(value = {"user","type","indirizzi"})
public class GestioneIndirizziController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value={"/gestioneIndirizzi.htm"}, method = RequestMethod.GET)
	public String addressFormGet(@ModelAttribute("user") String username,  Map<String,Object> model)
	{
		System.out.println("gestione indirizzi controller get");
		Set<Indirizzo> ind = userService.findByUsername(username).getIndirizzi();
		for (Iterator i = ind.iterator(); i.hasNext();) {
			Indirizzo indirizzo = (Indirizzo) i.next();
			System.out.println(indirizzo);
		}
		model.put("indirizzi",userService.findByUsername(username).getIndirizzi());
		return "gestioneIndirizzi";
	}

	@RequestMapping(value={"/gestioneIndirizzi.htm"}, method = RequestMethod.POST)
	public String addressFormPost(@ModelAttribute("user") String username, @ModelAttribute("indirizzi") Set<Indirizzo> indirizzi,  Map<String,Object> model)
	{
		System.out.println("gestione indirizzi controller post");
		for (Iterator i = indirizzi.iterator(); i.hasNext();) {
			Indirizzo indirizzo = (Indirizzo) i.next();
			System.out.println(indirizzo);
		}
		User u = userService.findByUsername(username);
		u.setIndirizzi(indirizzi);
		userService.update(u);
		Set<Indirizzo> ind = userService.findByUsername(username).getIndirizzi();
		for (Iterator i = ind.iterator(); i.hasNext();) {
			Indirizzo indirizzo = (Indirizzo) i.next();
			System.out.println(indirizzo);
		}
		return "gestioneIndirizzi";
	}
	
	@RequestMapping(value={"/aggiungiIndirizzo.htm"}, method = RequestMethod.GET)
	public String addAddressGet(@ModelAttribute("user") String username,  Map<String,Object> model)
	{
		System.out.println("aggiungi indirizzo controller get");
		model.put("indirizzo", new Indirizzo());
		return "aggiungiIndirizzo";
	}
	
	@RequestMapping(value={"/aggiungiIndirizzo.htm"}, method = RequestMethod.POST)
	public String addAddressPost(@ModelAttribute("user") String username, @ModelAttribute("indirizzo") Indirizzo indirizzo,  Map<String,Object> model)
	{
		User u = userService.findByUsername(username);
		u.getIndirizzi().add(indirizzo);
		userService.update(u);
		return "gestioneIndirizzi";
	}
}