package aeecommerce.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import aeecommerce.pojo.Document;
import aeecommerce.service.DocumentService;


@Controller
@SessionAttributes("document")
public class MenuAdminController{
	
	@Autowired
	DocumentService documentsService;
	
	@RequestMapping(value={"/gestioneHome.htm"}, method = RequestMethod.GET)
	public String getHome(ModelMap model){
		if( documentsService.load() == null )
			documentsService.save(new Document());
		System.out.println("Sent " + documentsService.load());
		model.put("document", documentsService.load());
		return "homeEditor";
	}
	
	@RequestMapping(value={"/gestioneHome.htm"}, method = RequestMethod.POST)
	public String getHomePost(@ModelAttribute("document") Document d){
		System.out.println("Update HOME");
		System.out.println("received " + d);
		documentsService.update(d);
		return "redirect:gestioneHome.htm";
	}
	
	@RequestMapping(value={"/gestioneFAQ.htm"}, method = RequestMethod.GET)
	public String getFaq(ModelMap model){
		if( documentsService.load() == null )
			documentsService.save(new Document());
		System.out.println("Sent " + documentsService.load());
		model.put("document", documentsService.load());
		return "faqEditor";
	}
	
	@RequestMapping(value={"/gestioneFAQ.htm"}, method = RequestMethod.POST)
	public String getFaqPost(@ModelAttribute("document") Document d){
		System.out.println("Update faq");
		System.out.println("received " + d);
		documentsService.update(d);
		return "redirect:gestioneFAQ.htm";
	}
	
	@RequestMapping(value={"/gestioneCondizioni.htm"}, method = RequestMethod.GET)
	public String getCond(ModelMap model){
		if( documentsService.load() == null )
			documentsService.save(new Document());
		System.out.println("Sent " + documentsService.load());
		model.put("document", documentsService.load());
		return "condizioniEditor";
	}
	
	@RequestMapping(value={"/gestioneCondizioni.htm"}, method = RequestMethod.POST)
	public String getCondPost(@ModelAttribute("document") Document d){
		System.out.println("Update cond");
		System.out.println("received " + d);
		documentsService.update(d);
		return "redirect:gestioneCondizioni.htm";
	}
	
	@RequestMapping(value={"/gestioneDoveSiamo.htm"}, method = RequestMethod.GET)
	public String getDoveSiamo(ModelMap model){
		if( documentsService.load() == null )
			documentsService.save(new Document());
		System.out.println("Sent " + documentsService.load());
		model.put("document", documentsService.load());
		return "doveSiamoEditor";
	}
	
	@RequestMapping(value={"/gestioneDoveSiamo.htm"}, method = RequestMethod.POST)
	public String getDoveSiamoPost(@ModelAttribute("document") Document d){
		System.out.println("Update DoveSiamo");
		System.out.println("received " + d);
		documentsService.update(d);
		return "redirect:gestioneDoveSiamo.htm";
	}
	
	@RequestMapping(value={"/gestioneContattaci.htm"}, method = RequestMethod.GET)
	public String getContattaci(ModelMap model){
		if( documentsService.load() == null )
			documentsService.save(new Document());
		System.out.println("Sent " + documentsService.load());
		model.put("document", documentsService.load());
		return "contattaciEditor";
	}
	
	@RequestMapping(value={"/gestioneContattaci.htm"}, method = RequestMethod.POST)
	public String getContattaciPost(@ModelAttribute("document") Document d){
		System.out.println("Update Contattaci");
		System.out.println("received " + d);
		documentsService.update(d);
		return "redirect:gestioneContattaci.htm";
	}
}