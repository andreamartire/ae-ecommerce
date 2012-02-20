package aeecommerce.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import aeecommerce.pojo.Carrello;
import aeecommerce.pojo.ElementoCarrello;
import aeecommerce.pojo.ModalitaPagamento;
import aeecommerce.pojo.TipoSpedizione;
import aeecommerce.service.CarrelloService;
import aeecommerce.service.ModalitaPagamentoService;
import aeecommerce.service.TipoSpedizioneService;
import aeecommerce.service.UserService;

@Controller
@SessionAttributes(value = {"user","type","name","carrello"})
public class CarrelloController {

	@Autowired
	CarrelloService carrelloService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	TipoSpedizioneService spedizioneService;
	
	@Autowired
	ModalitaPagamentoService pagamentoService;
	
	@RequestMapping(value = "addToCart.htm", method = RequestMethod.POST)
	public @ResponseBody String addToCart(@ModelAttribute("user") String username, @ModelAttribute("carrello") Object c,
			@RequestParam int idProdotto, @RequestParam int qnt) {
				
		if (c != null && c instanceof Carrello) {
			carrelloService.aggiungi(idProdotto, qnt, (Carrello) c);
		} else {
			System.out.println("CARRELLO = " + c);
			return "nop";
		}
		
		return "ok";
	}
	
	@RequestMapping(value = "updateCart.htm", method = RequestMethod.POST)
	public @ResponseBody String updateCart(@RequestParam int elementoCarrello, @RequestParam int qnt) {
	
		carrelloService.update(elementoCarrello, qnt);
		
		return "update";
	}
	
	@RequestMapping(value = "delFromCart.htm", method = RequestMethod.POST)
	public @ResponseBody String delFromCart(@RequestParam int elementoCarrello, @ModelAttribute("carrello") Object c) {
		
		if (c != null && c instanceof Carrello)
			carrelloService.remove(elementoCarrello, (Carrello) c);
		
		return "remove";
	}
	
	@RequestMapping(value = "carrello.htm", method = RequestMethod.GET)
	public String carrello(ModelMap model, @ModelAttribute("carrello") Object c) {
		List<ElementoCarrello> list = new ArrayList<ElementoCarrello>();
		
		if (c != null && c instanceof Carrello)
			list = carrelloService.list((Carrello) c);
		
		model.put("carrelloList", list);
		
		List<TipoSpedizione> listSpedizioni = spedizioneService.list();
		List<ModalitaPagamento> listPagamenti = pagamentoService.list();
		
		model.put("spedizioni", listSpedizioni);
		model.put("pagamenti", listPagamenti);
		
		return "carrello";
	}
	
	@RequestMapping(value = "carrelloJSON", method = RequestMethod.GET)
	public @ResponseBody String carrelloJSON(ModelMap model, @ModelAttribute("carrello") Object c) {
		List<ElementoCarrello> list = new ArrayList<ElementoCarrello>();
		
		if (c != null && c instanceof Carrello)
			list = carrelloService.list((Carrello) c);
		
		String carrelloJSON = "{\"carrello\":[";
		
		if (!list.isEmpty()) {
			for (ElementoCarrello e : list) {
				carrelloJSON += "{\"qnt\":\""+ e.getQuantita() +"\",\"id\":\""+e.getProdotto().getId()+"\",\"nome\":\""+ e.getProdotto().getNome() +"\",\"prezzo\":\""+ e.getProdotto().getPrezzoUnitario() +"\"},";
			}
			carrelloJSON = carrelloJSON.substring(0, carrelloJSON.length()-1);
		}
		
		carrelloJSON += "]}";
		
		return carrelloJSON;
	}
}
