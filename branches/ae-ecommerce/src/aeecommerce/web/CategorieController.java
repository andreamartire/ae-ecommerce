package aeecommerce.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import aeecommerce.pojo.Categoria;
import aeecommerce.service.CategoriaService;

@Controller
public class CategorieController {
	
	@Autowired
	CategoriaService catService;

	@RequestMapping(value = "/gestioneCategorie")
	public String gestioneCategorie() {
		return "categoriesManagement";
	}
	
	@RequestMapping(value = "/listCategorie")
	public @ResponseBody List<Categoria> getCategorie(ModelMap model) {
		List<Categoria> categorie = catService.list();
		
		return categorie;
	}
	
	@RequestMapping(value = "/eliminaCategoria")
	public @ResponseBody String addCategoria(ModelMap model) {
		
		Categoria c = new Categoria();
		c.setNome((String) model.get("nome"));
		c.setDescrizione((String) model.get("descrizione"));
		String parentString = (String) model.get("parent");
		if (!parentString.isEmpty())
		{
			Categoria parent = catService.findByName(parentString);
			c.setParent(parent);
		}
		
		return "added";
	}
	
	@RequestMapping(value = "/eliminaCategoria")
	public @ResponseBody String eliminaCategoria(@RequestParam int id) {
		catService.delete(id);
		
		return "added";
	}
	
	@RequestMapping(value = "/modificaCategoria")
	public @ResponseBody String modificaCategoria(@RequestParam int id) {
		Categoria c = catService.findById(id);
		catService.update(c);
		
		return "update";
	}
}
