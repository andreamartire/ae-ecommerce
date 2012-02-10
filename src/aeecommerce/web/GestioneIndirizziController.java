package aeecommerce.web;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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
@SessionAttributes(value = {"user","type","userdb", "indirizzo"})
public class GestioneIndirizziController {

	@Autowired
	UserService userService;
	
	@Autowired
	IndirizzoService indirizzoService;
	
	@RequestMapping(value={"/gestioneIndirizzi.htm"}, method = RequestMethod.GET)
	public String addressFormGet(@ModelAttribute("user") String username,  Map<String, User> model)
	{
		System.out.println("gestione indirizzi controller get");
		Set<Indirizzo> ind = userService.findByUsername(username).getIndirizzi();
		for (Iterator i = ind.iterator(); i.hasNext();) {
			Indirizzo indirizzo = (Indirizzo) i.next();
			System.out.println(indirizzo);
		}
		model.put("userdb",userService.findByUsername(username));
		return "gestioneIndirizzi";
	}

	@RequestMapping(value={"/gestioneIndirizzi.htm"}, method = RequestMethod.POST)
	public String addressFormPost(@ModelAttribute("user") String username, @ModelAttribute("userdb") User user,  Map<String,User> model)
	{
		System.out.println("gestione indirizzi controller post");
		for (Iterator i = user.getIndirizzi().iterator(); i.hasNext();) {
			Indirizzo indirizzo = (Indirizzo) i.next();
			System.out.println(indirizzo);
		}
		User u = userService.findByUsername(username);
		u.setIndirizzi(user.getIndirizzi());
		userService.update(u);
		Set<Indirizzo> ind = userService.findByUsername(username).getIndirizzi();
		for (Iterator i = ind.iterator(); i.hasNext();) {
			Indirizzo indirizzo = (Indirizzo) i.next();
			System.out.println(indirizzo);
		}
		return "redirect:gestioneIndirizzi.htm";
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
		return "redirect:gestioneIndirizzi.htm";
	}
	
	@RequestMapping(value={"/eliminaIndirizzo.htm"}, params="id")
	public String removeAddressGet(@RequestParam(value="id") int id,  Map<String,Object> model)
	{
		indirizzoService.delete(id);
		return "redirect:gestioneIndirizzi.htm";
	}
}