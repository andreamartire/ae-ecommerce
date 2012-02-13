package aeecommerce.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	@RequestMapping(value = "/listProdotti.htm")
	public @ResponseBody String listProdotti(@RequestParam int idCategoria) {
		
		String list = "{\"prodotti\":[";
		
		List<Prodotto> prodotti = prodService.list();
		
		if (!prodotti.isEmpty()) {
			for (Prodotto p : prodotti) {
				if (p.getCategoria().getId() == idCategoria) 
					list += "{\"id\":\""+p.getId()+"\",\"nome\":\""+p.getNome()+"\"},";
			}
			list = list.substring(0, list.length()-1);
		}
		list += "]}";
		
		return list;
	}
	
	@RequestMapping(value = "/aggiungiProdotto.htm", method = RequestMethod.POST)
	public @ResponseBody String aggiungiProdotto(@RequestParam int idCategoria, @RequestParam String nome) {
		
		Prodotto p = new Prodotto();
		p.setNome(nome);
		Categoria c = catService.findById(idCategoria);
		p.setCategoria(c);
		prodService.insert(p);
		
		return "ok";
	}
}
