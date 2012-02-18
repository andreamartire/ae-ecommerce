package aeecommerce.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import aeecommerce.service.CategoriaService;
import aeecommerce.service.ProdottoService;

@Controller
public class OfferteController {

	@Autowired
	ProdottoService prodService;
	
	@Autowired
	CategoriaService catService;
	
	@RequestMapping(value = "/gestioneOfferte.htm", method=RequestMethod.GET)
	public String gestioneOfferte() {
		return "gestioneOfferte";
	}
}
