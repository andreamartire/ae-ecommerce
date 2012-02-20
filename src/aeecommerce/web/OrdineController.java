package aeecommerce.web;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import aeecommerce.pojo.Carrello;
import aeecommerce.pojo.Cliente;
import aeecommerce.pojo.Indirizzo;
import aeecommerce.pojo.Ordine;
import aeecommerce.pojo.User;
import aeecommerce.service.CarrelloService;
import aeecommerce.service.ModalitaPagamentoService;
import aeecommerce.service.OrdineService;
import aeecommerce.service.TipoSpedizioneService;
import aeecommerce.service.UserService;

@Controller
@SessionAttributes(value = {"user","type","name","carrello","ordine"})
public class OrdineController {
	
	@Autowired
	CarrelloService carrelloService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	TipoSpedizioneService spedizioneService;
	
	@Autowired
	ModalitaPagamentoService pagamentoService;
	
	@Autowired
	OrdineService ordineService;

	@RequestMapping(value = "/storicoOrdini.htm", method = RequestMethod.GET)
	public String storicoOrdini(@ModelAttribute("user") String user, ModelMap model) {
		
		List<Ordine> list = new LinkedList<Ordine>();
		Cliente cliente = (Cliente) userService.findByUsername(user);
		
		for (Carrello c : cliente.getCarrelli()) {
			if (c.getOrdine() != null)
				list.add(c.getOrdine());
		}
		
		model.put("listOrdini", list);
		
		return "storicoOrdini";
	}
	
	@RequestMapping(value = "/ordine.htm", method = RequestMethod.POST)
	public String ordine(@ModelAttribute("carrello") Object carrello, ModelMap model, 
			@RequestParam int idSpedizione, @RequestParam int idPagamento, 
			@RequestParam int pesoTotale, @RequestParam double totaleDaPagare) {
		
		if (carrello instanceof Carrello) {
			Ordine ordine = new Ordine();
			ordine.setCarrello((Carrello) carrello);
			ordine.setData(new Date());
			ordine.setModalitaPagamento(pagamentoService.findById(idPagamento));
			ordine.setTipoSpedizione(spedizioneService.findById(idSpedizione));
			ordine.setPesoTotaleApprossimato(pesoTotale);
			ordine.setTotaleDaPagare(totaleDaPagare);
			model.put("ordine", ordine);
		}
		
		return "ordine";
	}
	
	@RequestMapping(value = "/proseguiOrdine.htm", method = RequestMethod.POST)
	public String proseguiOrdine(@ModelAttribute("carrello") Object carrello, @ModelAttribute("ordine") Ordine ordine, ModelMap model, 
			@RequestParam String dest, @RequestParam String via, @RequestParam String num,
			@RequestParam String citta, @RequestParam String prov, @RequestParam String cap) {
				
		Indirizzo indirizzo = new Indirizzo();
		indirizzo.setDestinatario(dest);
		indirizzo.setVia(via);
		indirizzo.setCap(cap);
		indirizzo.setCitta(citta);
		indirizzo.setProvincia(prov);
		indirizzo.setNumero(num);
		
		ordine.setDestinazione(indirizzo);
		
		model.put("carrelloList", carrelloService.list((Carrello) carrello));
		
		return "riepilogoOrdine";
	}
	
	@RequestMapping(value = "/concludiOrdine.htm", method = RequestMethod.GET)
	public String concludiOrdine(@ModelAttribute("ordine") Ordine ordine, @ModelAttribute("carrello") Carrello carrello, ModelMap model) {
				
		System.out.println("Ordine confermato: " + ordine);
		ordineService.insert(ordine);
		
		carrello.setOrdine(ordine);
		carrelloService.save(carrello);
		
		return "ordineConfermato";
	}
}
