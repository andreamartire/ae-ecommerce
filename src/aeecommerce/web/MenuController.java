package aeecommerce.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import aeecommerce.pojo.Amministratore;
import aeecommerce.service.DocumentService;
import aeecommerce.service.UserService;


@Controller
public class MenuController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	DocumentService documentService;
	
	@RequestMapping(value={"/home.htm"}, method = RequestMethod.GET)
	public String getHome(ModelMap model)
	{
		Amministratore admin = new Amministratore();
		admin.setUsername("admin");
		admin.setPassword("admin");
		if (userService.findByUsername("admin") == null) {
			userService.insert(admin);
		}
		
		return "home";
	}
	
	@RequestMapping(value={"/home.htm"}, method = RequestMethod.POST)
	public String getLogin(ModelMap model)
	{
		System.out.println("Home controller post " + model.get("user"));
		return "login";
	}
	
	@RequestMapping(value={"/faq.htm"}, method = RequestMethod.GET)
	public String getFaq(ModelMap model)
	{
		model.put("data", documentService.load().toDocumentForm().getFaq());
		return "faq";
	}
	
	@RequestMapping(value={"/condizioni.htm"}, method = RequestMethod.GET)
	public String getCondition(ModelMap model)
	{
		model.put("data", documentService.load().toDocumentForm().getConditions());
		return "faq";
	}
}