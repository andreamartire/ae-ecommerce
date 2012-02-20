package aeecommerce.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import aeecommerce.pojo.Amministratore;
import aeecommerce.pojo.Document;
import aeecommerce.pojo.ModalitaPagamento;
import aeecommerce.pojo.TipoSpedizione;
import aeecommerce.service.DocumentService;
import aeecommerce.service.ModalitaPagamentoService;
import aeecommerce.service.SpedizioniService;
import aeecommerce.service.UserService;
import aeecommerce.service.VetrinaService;


@Controller
@SessionAttributes(value = {"user","type","name","carrello"})
public class MenuStandardController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	DocumentService documentService;
	
	@Autowired
	SpedizioniService spedizioniService;
	
	@Autowired
	ModalitaPagamentoService modalitaPagamentoService;
	
	@Autowired
	VetrinaService vetrinaService;
	
	@RequestMapping(value={"/home.htm"}, method = RequestMethod.GET)
	public String getHome(ModelMap model)
	{
		Amministratore admin = new Amministratore();
		admin.setUsername("admin");
		admin.setPassword("admin");
		if (userService.findByUsername("admin") == null) {
			userService.insert(admin);
		}
		
		if (model.get("user") == null) {
			model.put("user", "");
			model.put("name", "");
			model.put("type", "");
			model.put("carrello", "");
		}
		if( documentService.load() == null )
			documentService.save(new Document());
		model.put("data", documentService.load().getHome());
		model.put("prodottiVetrina", vetrinaService.load().getProdotti());
		
		return "home";
	}
	
	@RequestMapping(value={"/home.htm"}, method = RequestMethod.POST)
	public String getLogin(ModelMap model)
	{
		System.out.println("Home controller post " + model.get("user"));
		return "login";
	}
	
	@RequestMapping(value={"/spedizioni.htm"}, method = RequestMethod.GET)
	public String getSpedizioni(ModelMap model)
	{
		List<TipoSpedizione> list = spedizioniService.findAll();
		
		model.put("spedizioni", list);
		return "spedizioni";
	}
	
	@RequestMapping(value={"/pagamenti.htm"}, method = RequestMethod.GET)
	public String getPagamenti(ModelMap model)
	{
		List<ModalitaPagamento> list = modalitaPagamentoService.list();
		
		model.put("pagamenti", list);
		return "pagamenti";
	}
	
	@RequestMapping(value={"/faq.htm"}, method = RequestMethod.GET)
	public String getFaq(ModelMap model)
	{
		if( documentService.load() == null )
			documentService.save(new Document());
		model.put("data", documentService.load().getFaq());
		return "output";
	}
	
	@RequestMapping(value={"/condizioni.htm"}, method = RequestMethod.GET)
	public String getCondition(ModelMap model)
	{
		if( documentService.load() == null )
			documentService.save(new Document());
		model.put("data", documentService.load().getConditions());
		return "output";
	}
	
	@RequestMapping(value={"/doveSiamo.htm"}, method = RequestMethod.GET)
	public String getDoveSiamo(ModelMap model)
	{
		if( documentService.load() == null )
			documentService.save(new Document());
		model.put("data", documentService.load().getDoveSiamo());
		return "output";
	}
	
	@RequestMapping(value={"/contattaci.htm"}, method = RequestMethod.GET)
	public String getContattaci(ModelMap model)
	{
		if( documentService.load() == null )
			documentService.save(new Document());
		model.put("data", documentService.load().getContattaci());
		return "output";
	}
}