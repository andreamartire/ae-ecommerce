package aeecommerce.web;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
@SessionAttributes(value = {"user","type","userdb", "indirizzo", "id"})
public class IndirizziAdminController {

	@Autowired
	UserService userService;
	
	@Autowired
	IndirizzoService indirizzoService;
	
	@RequestMapping(value={"/gestioneIndirizziAdmin.htm"}, method = RequestMethod.GET)
	public String addressFormGet(@ModelAttribute("id") int id,  Map<String, User> model)
	{
		System.out.println("gestione indirizzi admin controller get");
		Set<Indirizzo> ind = userService.findById(id).getIndirizzi();
		for (Iterator i = ind.iterator(); i.hasNext();) {
			Indirizzo indirizzo = (Indirizzo) i.next();
			System.out.println(indirizzo);
		}
		model.put("userdb",userService.findById(id));
		return "gestioneIndirizziAdmin";
	}

	@RequestMapping(value={"/gestioneIndirizziAdmin.htm"}, method = RequestMethod.POST)
	public String addressFormPost(@ModelAttribute("id") int id, @ModelAttribute("userdb") User user)
	{
		System.out.println("gestione indirizzi controller post");
		for (Iterator<Indirizzo> i = user.getIndirizzi().iterator(); i.hasNext();) {
			Indirizzo indirizzo = (Indirizzo) i.next();
			System.out.println(indirizzo);
		}
		User u = userService.findById(id);
		u.setIndirizzi(user.getIndirizzi());
		userService.update(u);
		Set<Indirizzo> ind = userService.findById(id).getIndirizzi();
		for (Iterator<Indirizzo> i = ind.iterator(); i.hasNext();) {
			Indirizzo indirizzo = (Indirizzo) i.next();
			System.out.println(indirizzo);
		}
		return "redirect:gestioneIndirizziAdmin.htm";
	}
	
	@RequestMapping(value={"/aggiungiIndirizzoAdmin.htm"}, method = RequestMethod.GET)
	public String addAddressGet(Map<String,Object> model)
	{
		System.out.println("aggiungi indirizzo admin controller get");
		model.put("indirizzo", new Indirizzo());
		return "aggiungiIndirizzoAdmin";
	}
	
	@RequestMapping(value={"/aggiungiIndirizzoAdmin.htm"}, method = RequestMethod.POST)
	public String addAddressPost(@ModelAttribute("id") int id, @ModelAttribute("indirizzo") Indirizzo indirizzo)
	{
		User u = userService.findById(id);
		u.getIndirizzi().add(indirizzo);
		userService.update(u);
		return "redirect:gestioneIndirizziAdmin.htm";
	}
	
	@RequestMapping(value={"/eliminaIndirizzoAdmin.htm"}, params="idAddress")
	public String removeAddressGet(@RequestParam(value="idAddress") int id)
	{
		indirizzoService.delete(id);
		return "redirect:gestioneIndirizziAdmin.htm";
	}
}