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
@SessionAttributes(value = {"user","type","userdb", "recapito", "id", "idRecapito"})
public class RecapitiAdminController {

	@Autowired
	UserService userService;
	
	@Autowired
	RecapitoService recapitoService;
	
	@RequestMapping(value={"/gestioneRecapitiAdmin.htm"}, method = RequestMethod.GET)
	public String addressFormGet(@ModelAttribute("id") int id,  Map<String, User> model)
	{
		System.out.println("gestione recapiti admin controller get");
		Set<Recapito> ind = userService.findById(id).getRecapiti();
		for (Iterator i = ind.iterator(); i.hasNext();) {
			Recapito recapito = (Recapito) i.next();
			System.out.println(recapito);
		}
		model.put("userdb",userService.findById(id));
		return "gestioneRecapitiAdmin";
	}

	@RequestMapping(value={"/gestioneRecapitiAdmin.htm"}, method = RequestMethod.POST)
	public String addressFormPost(@ModelAttribute("id") int id, @ModelAttribute("userdb") User user,  Map<String,User> model)
	{
		System.out.println("gestione Recapiti controller post");
		for (Iterator i = user.getRecapiti().iterator(); i.hasNext();) {
			Recapito Recapito = (Recapito) i.next();
			System.out.println(Recapito);
		}
		User u = userService.findById(id);
		u.setRecapiti(user.getRecapiti());
		userService.update(u);
		Set<Recapito> ind = userService.findById(id).getRecapiti();
		for (Iterator i = ind.iterator(); i.hasNext();) {
			Recapito Recapito = (Recapito) i.next();
			System.out.println(Recapito);
		}
		return "redirect:gestioneRecapitiAdmin.htm";
	}
	
	@RequestMapping(value={"/aggiungiRecapitoAdmin.htm"}, method = RequestMethod.GET)
	public String addAddressGet(Map<String,Object> model)
	{
		System.out.println("aggiungi Recapito admin controller get");
		model.put("recapito", new Recapito());
		return "aggiungiRecapitoAdmin";
	}
	
	@RequestMapping(value={"/aggiungiRecapitoAdmin.htm"}, method = RequestMethod.POST)
	public String addRecapitoPost(@ModelAttribute("id") int id, @ModelAttribute("Recapito") Recapito Recapito,  Map<String,Object> model)
	{
		User u = userService.findById(id);
		u.getRecapiti().add(Recapito);
		userService.update(u);
		return "redirect:gestioneRecapitiAdmin.htm";
	}
	
	@RequestMapping(value={"/eliminaRecapitoAdmin.htm"}, params="idRecapito")
	public String removeRecapitoGet(@RequestParam(value="idRecapito") int id,  Map<String,Object> model)
	{
		recapitoService.delete(id);
		return "redirect:gestioneRecapitiAdmin.htm";
	}
}