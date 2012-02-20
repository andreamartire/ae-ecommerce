package aeecommerce.web;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import aeecommerce.pojo.Prodotto;
import aeecommerce.pojo.Vetrina;
import aeecommerce.service.CategoriaService;
import aeecommerce.service.ProdottoService;
import aeecommerce.service.VetrinaService;

@Controller
public class VetrinaController {

	@Autowired
	ProdottoService prodService;
	
	@Autowired
	CategoriaService catService;
	
	@Autowired
	VetrinaService vetrinaService;
	
	@RequestMapping(value = "/gestioneVetrina.htm", method=RequestMethod.GET)
	public String gestioneVetrina(ModelMap model) {
		if(vetrinaService.load() == null)
			vetrinaService.save(new Vetrina());
		model.put("prodottiVetrina", vetrinaService.load().getProdotti());
		return "gestioneVetrina";
	}
	
	@RequestMapping(value = "/aggiungiProdottoVetrina.htm", method=RequestMethod.POST)
	public String aggiungiProdotto(@RequestParam int idProdotto, ModelMap model) {
		if(vetrinaService.load() == null)
			vetrinaService.save(new Vetrina());
		
		for (Iterator iterator = vetrinaService.load().getProdotti().iterator(); iterator.hasNext();) {
			Prodotto p = (Prodotto) iterator.next();
			if(p.getId() == idProdotto){
				System.out.println("Prodotto gia' presente");
				model.put("prodottiVetrina", vetrinaService.load().getProdotti());
				return "gestioneVetrina";
			}
		}
		
		Vetrina vetrina = vetrinaService.load();
		Prodotto prod = prodService.findById(idProdotto);
		vetrina.getProdotti().add(prod);
		vetrinaService.update(vetrina);
		System.out.println("aggiunto prodotto");
		model.put("prodottiVetrina", vetrinaService.load().getProdotti());
		return "gestioneVetrina";
	}
	
	@RequestMapping(value = "/eliminaProdottoVetrina.htm", method=RequestMethod.POST)
	public @ResponseBody String eliminaProdotto(@RequestParam int idProdotto, ModelMap model) {
		System.out.println("del form vetrina post " + idProdotto);
		vetrinaService.deleteProdotto(idProdotto);
		System.out.println("rimosso prodotto");
		return "success";
	}
}
