package aeecommerce.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import aeecommerce.pojo.Carrello;
import aeecommerce.pojo.ElementoCarrello;
import aeecommerce.service.CarrelloService;
import aeecommerce.service.UserService;

@Controller
public class CarrelloController {

	@Autowired
	CarrelloService carrelloService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "addToCart.htm", method = RequestMethod.POST)
	public @ResponseBody String addToCart(@RequestParam int idProdotto, @RequestParam int qnt, HttpSession session) {
		
		Carrello c = (Carrello) session.getAttribute("carrello");
		
		if (c == null) {
			System.out.println("CARRELLO NULL");
			return "";
		}
		
		carrelloService.aggiungi(idProdotto, qnt, c);
		
		return "added";
	}
	
	@RequestMapping(value = "updateCart.htm", method = RequestMethod.POST)
	public @ResponseBody String updateCart(@RequestParam int elementoCarrello, @RequestParam int qnt, HttpSession session) {
	
		carrelloService.update(elementoCarrello, qnt);
		
		return "added";
	}
	
	@RequestMapping(value = "delFromCart.htm", method = RequestMethod.POST)
	public @ResponseBody String delFromCart(@RequestParam int elementoCarrello, HttpSession session) {
		
		System.out.println("remove " + elementoCarrello);
		
		Carrello c = (Carrello) session.getAttribute("carrello");
		
		carrelloService.remove(elementoCarrello, c);
		
		return "remove";
	}
	
	@RequestMapping(value = "carrello.htm", method = RequestMethod.GET)
	public String carrello(ModelMap model, HttpSession session) {
		List<ElementoCarrello> list = new ArrayList<ElementoCarrello>();
		if (session.getAttribute("carrello") instanceof Carrello) {
			list = carrelloService.list((Carrello) session.getAttribute("carrello"));
		}
		model.put("carrello", list);
		
		return "carrello";
	}
	
	@RequestMapping(value = "carrelloJSON", method = RequestMethod.GET)
	public @ResponseBody String carrelloJSON(ModelMap model, HttpSession session) {
		List<ElementoCarrello> list = new ArrayList<ElementoCarrello>();
		if (session.getAttribute("carrello") instanceof Carrello) {
			list = carrelloService.list((Carrello) session.getAttribute("carrello"));
		}
		String carrelloJSON = "{\"carrello\":[";
		
		if (!list.isEmpty()) {
			for (ElementoCarrello e : list) {
				carrelloJSON += "{\"qnt\":\""+ e.getQuantita() +"\",\"id\":\""+e.getProdotto().getId()+"\",\"nome\":\""+ e.getProdotto().getNome() +"\",\"prezzo\":\""+ e.getProdotto().getPrezzoUnitario() +"\"},";
			}
			carrelloJSON = carrelloJSON.substring(0, carrelloJSON.length()-1);
		}
		
		carrelloJSON += "]}";
		System.out.println(carrelloJSON);
		
		return carrelloJSON;
	}
}
