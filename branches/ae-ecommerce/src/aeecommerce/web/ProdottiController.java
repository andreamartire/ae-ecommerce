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

import aeecommerce.pojo.Categoria;
import aeecommerce.pojo.Prodotto;
import aeecommerce.service.CategoriaService;
import aeecommerce.service.ProdottoService;

@Controller
public class ProdottiController {

	@Autowired
	ProdottoService prodService;
	
	@Autowired
	CategoriaService catService;
	
	@RequestMapping(value = "/prodotti", method = RequestMethod.GET)
	public String prodotti(@RequestParam int id, ModelMap model) {
		
		Prodotto p = prodService.findById(id);
		
		model.put("prodotto",p);
		
		return "prodotti";
	}
	
	@RequestMapping(value = "/listProdotti.htm")
	public @ResponseBody String listProdotti(@RequestParam int idCategoria) {
		
		String list = "{\"prodotti\":[";
		
		List<Prodotto> prodotti = prodService.list();
		
		for (Prodotto p : prodotti) {
			if (p.getCategoria().getId() == idCategoria) 
				list += "{\"id\":\""+p.getId()+"\",\"nome\":\""+p.getNome()+"\"},";
		}
		if (list.endsWith(","))
			list = list.substring(0, list.length()-1);
		list += "]}";
		
		return list;
	}
	
	@RequestMapping(value = "/editorProdotto.htm", method = RequestMethod.GET)
	public String modificaProdotto(@RequestParam int id, ModelMap model) {
		
		model.put("prodotto", prodService.findById(id));
		
		return "modificaProdotto";
	}
	
	@RequestMapping(value = "/elencoProdotti.htm", method = RequestMethod.GET)
	public String elencoProdotti(@RequestParam int idCategoria, ModelMap model) {
		
		List<Prodotto> prodotti = prodService.list();
		List<Prodotto> list = new ArrayList<Prodotto>();
		
		for (Prodotto p : prodotti) {
			if (p.getCategoria().getId() == idCategoria) 
				list.add(p);
		}
		
		model.put("categoria", catService.findById(idCategoria));
		model.put("prodotti", list);
		
		return "elencoProdotti";
	}
	
	@RequestMapping(value = "/gestioneProdotti.htm", method = RequestMethod.GET)
	public String gestioneProdotti(@RequestParam int idCategoria, ModelMap model) {
		
		List<Prodotto> prodotti = prodService.list();
		List<Prodotto> list = new ArrayList<Prodotto>();
		
		for (Prodotto p : prodotti) {
			if (p.getCategoria().getId() == idCategoria) 
				list.add(p);
		}
		
		model.put("categoria", catService.findById(idCategoria));
		model.put("prodotti", list);
		
		return "productsManagement";
	}
	
	@RequestMapping(value = "/aggiungiProdotto.htm", method = RequestMethod.POST)
	public @ResponseBody String aggiungiProdotto(HttpServletRequest model) {
		
		System.out.println("aggiungo " + model.getParameter("nome") + " a " + model.getParameter("idCategoria")); 
		
		Prodotto p = new Prodotto();
		p.setNome((String) model.getParameter("nome"));
		p.setPercentualeIVA(Double.parseDouble(model.getParameter("iva")));
		p.setPesoApprossimato(Integer.parseInt(model.getParameter("peso")));
		p.setPrezzoUnitario(Double.parseDouble(model.getParameter("prezzo")));
		p.setDescrizione(model.getParameter("descrizione"));
		Categoria c = catService.findById(Integer.parseInt(model.getParameter("idCategoria")));
		p.setCategoria(c);
		prodService.insert(p);
		
		return "Prodotto " + model.getParameter("nome") + " aggiunto alla categoria " + model.getParameter("idCategoria");
	}
	
	@RequestMapping(value = "/eliminaProdotto.htm", method = RequestMethod.POST)
	public @ResponseBody String eliminaProdotto(@RequestParam int idCategoria, @RequestParam int idProdotto) {
		
		Prodotto p = prodService.findById(idProdotto);
		prodService.delete(p);
		
		return "Prodotto " + idProdotto + " eliminato dalla categoria " + idCategoria;
	}
	
	@RequestMapping(value = "/modificaProdotto.htm", method = RequestMethod.POST)
	public @ResponseBody String modificaProdotto(HttpServletRequest model) {
		
		Prodotto p = prodService.findById(Integer.parseInt(model.getParameter("idProdotto")));
		
		p.setNome((String) model.getParameter("nome"));
		p.setPercentualeIVA(Double.parseDouble(model.getParameter("iva")));
		p.setPesoApprossimato(Integer.parseInt(model.getParameter("peso")));
		p.setPrezzoUnitario(Double.parseDouble(model.getParameter("prezzo")));
		p.setDescrizione(model.getParameter("descrizione"));
		
		prodService.update(p);
		
		return "ok";
	}
}
