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

import aeecommerce.pojo.Recapito;
import aeecommerce.pojo.User;
import aeecommerce.service.RecapitoService;
import aeecommerce.service.UserService;

@Controller
@SessionAttributes(value = {"user","type","userdb", "recapito"})
public class RecapitiController {

	@Autowired
	UserService userService;
	
	@Autowired
	RecapitoService recapitoService;
	
	@RequestMapping(value={"/gestioneRecapiti.htm"}, method = RequestMethod.GET)
	public String addressFormGet(@ModelAttribute("user") String username,  Map<String, User> model)
	{
		System.out.println("gestione recapiti controller get");
		Set<Recapito> ind = userService.findByUsername(username).getRecapiti();
		for (Iterator i = ind.iterator(); i.hasNext();) {
			Recapito rec = (Recapito) i.next();
			System.out.println(rec);
		}
		model.put("userdb",userService.findByUsername(username));
		return "gestioneRecapiti";
	}

	@RequestMapping(value={"/gestioneRecapiti.htm"}, method = RequestMethod.POST)
	public String addressFormPost(@ModelAttribute("user") String username, @ModelAttribute("userdb") User user,  Map<String,User> model)
	{
		System.out.println("gestione recapiti controller post");
		for (Iterator i = user.getRecapiti().iterator(); i.hasNext();) {
			Recapito rec = (Recapito) i.next();
			System.out.println(rec);
		}
		User u = userService.findByUsername(username);
		u.setRecapiti(user.getRecapiti());
		userService.update(u);
		Set<Recapito> ind = userService.findByUsername(username).getRecapiti();
		for (Iterator i = ind.iterator(); i.hasNext();) {
			Recapito rec = (Recapito) i.next();
			System.out.println(rec);
		}
		return "redirect:gestioneRecapiti.htm";
	}
	
	@RequestMapping(value={"/aggiungiRecapito.htm"}, method = RequestMethod.GET)
	public String addAddressGet(@ModelAttribute("user") String username,  Map<String,Object> model)
	{
		System.out.println("aggiungi Recapito controller get");
		model.put("recapito", new Recapito());
		return "aggiungiRecapito";
	}
	
	@RequestMapping(value={"/aggiungiRecapito.htm"}, method = RequestMethod.POST)
	public String addAddressPost(@ModelAttribute("user") String username, @ModelAttribute("recapito") Recapito recapito,  Map<String,Object> model)
	{
		User u = userService.findByUsername(username);
		u.getRecapiti().add(recapito);
		userService.update(u);
		return "redirect:gestioneRecapiti.htm";
	}
	
	@RequestMapping(value={"/eliminaRecapito.htm"}, params="id")
	public String removeAddressGet(@RequestParam(value="id") int id,  Map<String,Object> model)
	{
		recapitoService.delete(id);
		return "redirect:gestioneRecapiti.htm";
	}
}