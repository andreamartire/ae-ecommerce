package aeecommerce.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import aeecommerce.pojo.Categoria;
import aeecommerce.service.CategoriaService;

@Controller
public class CategorieController {
	
	@Autowired
	CategoriaService catService;

	@RequestMapping(value = "/listCategorie")
	public @ResponseBody List<Categoria> getCategorie(ModelMap model) {
		List<Categoria> categorie = catService.list();
		
		return categorie;
	}
}
