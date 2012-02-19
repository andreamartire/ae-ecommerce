package aeecommerce.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import aeecommerce.pojo.Categoria;
import aeecommerce.service.CategoriaService;

@Controller
public class CategorieController {
	
	@Autowired
	CategoriaService catService;
	
	@RequestMapping(value = "/listCategorie.htm", method=RequestMethod.GET)
	public @ResponseBody String listCategorie() {
		List<Categoria> categorie = catService.list();
		
		if (categorie.isEmpty())
			return  "{\"categorie\":[]}";
		
		String json = "{\"categorie\":[";
		
		for (Categoria c : categorie) {
			if (c.getParent() == null) {
				json += "{\"id\":\"" + c.getId() + "\",";
				json += "\"nome\":\"" + c.getNome() + "\",";
				json += "\"children\":[";
				if (c.getChildren() != null && !c.getChildren().isEmpty()) {
					for (Categoria s1 : c.getChildren()) {
						json += "{\"id\":\"" + s1.getId() + "\",";
						json += "\"nome\":\"" + s1.getNome() + "\","; 
						json += "\"children\":[";
						if (s1.getChildren() != null && !s1.getChildren().isEmpty()) {
							for (Categoria s11 : s1.getChildren()) {
								json += "{\"id\":\"" + s11.getId() + "\",";
								json += "\"nome\":\"" + s11.getNome() + "\"},";
							}
							json = json.substring(0, json.length()-1);
						} 
						json += "]},";
					}
					json = json.substring(0, json.length()-1);
				}
				json += "]},";
			}
		}
		json = json.substring(0, json.length()-1);
		json += "]}";
		
		return json;
	}

	@RequestMapping(value = "/gestioneCategorie.htm")
	public String gestioneCategorie(ModelMap model) {
		List<Categoria> categorie = catService.list();
		model.put("categorie", categorie);
		return "categoriesManagement";
	}
	
	@RequestMapping(value = "/aggiungiCategoria", method = RequestMethod.POST)
	public @ResponseBody String addCategoria(@RequestParam int parentId, @RequestParam String nome) {
		
		Categoria categoria = new Categoria();
		categoria.setNome(nome);
		if (parentId >= 0)
		{
			Categoria parent = catService.findById(parentId);
			categoria.setParent(parent);
		}
		catService.insert(categoria);
		
		return "ok";
	}
	
	@RequestMapping(value = "/aggiungiCategoria", method = RequestMethod.GET)
	public String addCategoria(@RequestParam int parentId, ModelMap model) {
		
		model.put("command", new Categoria());
		
		System.out.println(parentId);
		model.put("parentId", parentId);
		
		return "aggiungiCategoria";
	}
	
	@RequestMapping(value = "/modificaCategoria", method = RequestMethod.POST)
	public @ResponseBody String editCategoria(@RequestParam int id, @RequestParam String nome) {
		
		Categoria categoria = catService.findById(id);
		categoria.setNome(nome);
		catService.update(categoria);
		
		return "ok";
	}
	
	@RequestMapping(value = "/eliminaCategoria", method = RequestMethod.POST)
	public @ResponseBody String eliminaCategoria(@RequestParam int id) {
		catService.delete(id);
		
		return "ok";
	}
}
