package aeecommerce.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		model.put("vetrinaProdotti", vetrinaService.load().getProdotti());
		return "gestioneVetrina";
	}
}
