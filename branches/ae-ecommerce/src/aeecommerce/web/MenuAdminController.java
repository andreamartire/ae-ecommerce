package aeecommerce.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import aeecommerce.pojo.Document;
import aeecommerce.pojo.DocumentForm;
import aeecommerce.service.DocumentService;


@Controller
@SessionAttributes("document")
public class MenuAdminController{
	
	@Autowired
	DocumentService documentsService;
	
	@RequestMapping(value={"/gestioneFAQ.htm"}, method = RequestMethod.GET)
	public String getFaq(ModelMap model){
		if( documentsService.load() == null )
			documentsService.save(new Document());
		System.out.println("Sent " + documentsService.load());
		model.put("document", documentsService.load().toDocumentForm());
		return "faqEditor";
	}
	
	@RequestMapping(value={"/gestioneFAQ.htm"}, method = RequestMethod.POST)
	public String getFaqPost(@ModelAttribute("document") DocumentForm d){
		System.out.println("Update faq");
		System.out.println("received " + d);
		documentsService.update(d.toDocument());
		return "redirect:gestioneFAQ.htm";
	}
	
	@RequestMapping(value={"/gestioneCondizioni.htm"}, method = RequestMethod.GET)
	public String getCond(ModelMap model){
		if( documentsService.load() == null )
			documentsService.save(new Document());
		System.out.println("Sent " + documentsService.load());
		model.put("document", documentsService.load().toDocumentForm());
		return "condizioniEditor";
	}
	
	@RequestMapping(value={"/gestioneCondizioni.htm"}, method = RequestMethod.POST)
	public String getCondPost(@ModelAttribute("document") DocumentForm d){
		System.out.println("Update cond");
		System.out.println("received " + d);
		documentsService.update(d.toDocument());
		return "redirect:gestioneCondizioni.htm";
	}
	
	@RequestMapping(value={"/gestioneDoveSiamo.htm"}, method = RequestMethod.GET)
	public String getDoveSiamo(ModelMap model){
		if( documentsService.load() == null )
			documentsService.save(new Document());
		System.out.println("Sent " + documentsService.load());
		model.put("document", documentsService.load().toDocumentForm());
		return "doveSiamoEditor";
	}
	
	@RequestMapping(value={"/gestioneDoveSiamo.htm"}, method = RequestMethod.POST)
	public String getDoveSiamoPost(@ModelAttribute("document") DocumentForm d){
		System.out.println("Update DoveSiamo");
		System.out.println("received " + d);
		documentsService.update(d.toDocument());
		return "redirect:gestioneDoveSiamo.htm";
	}
	
	@RequestMapping(value={"/gestioneContattaci.htm"}, method = RequestMethod.GET)
	public String getContattaci(ModelMap model){
		if( documentsService.load() == null )
			documentsService.save(new Document());
		System.out.println("Sent " + documentsService.load());
		model.put("document", documentsService.load().toDocumentForm());
		return "contattaciEditor";
	}
	
	@RequestMapping(value={"/gestioneContattaci.htm"}, method = RequestMethod.POST)
	public String getContattaciPost(@ModelAttribute("document") DocumentForm d){
		System.out.println("Update Contattaci");
		System.out.println("received " + d);
		documentsService.update(d.toDocument());
		return "redirect:gestioneContattaci.htm";
	}
}