package aeecommerce.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import aeecommerce.pojo.TipoSpedizione;
import aeecommerce.service.TipoSpedizioneService;

@Controller
public class TipoSpedizioneController {

	@Autowired
	TipoSpedizioneService tipoSpedizioneService;
	
	@RequestMapping(value = "/gestioneTipoSpedizione.htm", method = RequestMethod.GET)
	public String gestioneSpedizioni(ModelMap model) {
		
		List<TipoSpedizione> spedizioni = tipoSpedizioneService.list();
		List<TipoSpedizione> list = new ArrayList<TipoSpedizione>();
		
		for (TipoSpedizione p : spedizioni)
			list.add(p);
		
		model.put("spedizioni", list);
		
		return "tipoSpedizioneManagement";
	}
	
	@RequestMapping(value = "/aggiungiTipoSpedizione.htm", method = RequestMethod.POST)
	public @ResponseBody String aggiungiTipoSpedizione(HttpServletRequest model) {
		
		System.out.println("aggiungo TipoSpedizione " + model.getParameter("nome")); 
		
		TipoSpedizione p = new TipoSpedizione();
		p.setNome((String) model.getParameter("nome"));
		p.setDescrizione(model.getParameter("descrizione"));
		p.setPrezzoBase(Double.parseDouble(model.getParameter("prezzoBase")));
		System.out.println(p);
		tipoSpedizioneService.insert(p);
		
		return "TipoSpedizione " + model.getParameter("nome") + " aggiunto";
	}
	
	@RequestMapping(value = "/eliminaTipoSpedizione.htm", method = RequestMethod.POST)
	public @ResponseBody String eliminaTipoSpedizione(@RequestParam int idTipoSpedizione) {
		
		TipoSpedizione p = tipoSpedizioneService.findById(idTipoSpedizione);
		tipoSpedizioneService.delete(p);
		
		return "TipoSpedizione " + idTipoSpedizione ;
	}
	
	@RequestMapping(value = "/modificaTipoSpedizione.htm", method = RequestMethod.POST)
	public @ResponseBody String modificaTipoSpedizione(HttpServletRequest model) {
		
		TipoSpedizione p = tipoSpedizioneService.findById(Integer.parseInt(model.getParameter("idTipoSpedizione")));
		
		p.setNome((String) model.getParameter("nome"));
		p.setDescrizione(model.getParameter("descrizione"));
		p.setPrezzoBase(Double.parseDouble(model.getParameter("prezzoBase")));
		
		tipoSpedizioneService.update(p);
		
		return "ok";
	}
}
