package aeecommerce.web;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import aeecommerce.pojo.Carrello;
import aeecommerce.service.CarrelloService;

@Controller
@SessionAttributes({"carrello"})
public class CarrelloController {

	@Autowired
	CarrelloService carrelloService;
	
	@RequestMapping(value = "addToCart.htm", method = RequestMethod.POST)
	public @ResponseBody String addToCart(@RequestParam int idProdotto, @RequestParam int qnt, ModelMap model) {
		
		Carrello c = (Carrello) model.get("carrello");
		
		if (c == null) {
			c = new Carrello();
			c.setDataCreazione(new Date());
			model.put("carrello", c);
		}
		
		carrelloService.aggiungi(idProdotto, qnt, c);
		
		return "added";
	}
	
	@RequestMapping(value = "delFromCart.htm", method = RequestMethod.POST)
	public @ResponseBody String delFromCart(@RequestParam int elementoCarrello, ModelMap model) {
		
		System.out.println("remove " + elementoCarrello);
		
		Carrello c = (Carrello) model.get("carrello");
		
		carrelloService.remove(elementoCarrello, c);
		
		return "remove";
	}
	
	@RequestMapping(value = "carrello.htm", method = RequestMethod.GET)
	public String carrello(ModelMap model) {
		
		return "carrello";
	}
}
