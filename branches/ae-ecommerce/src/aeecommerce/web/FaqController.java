package aeecommerce.web;

import java.io.IOException;

import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class FaqController {
	
	@RequestMapping(value={"/gestioneFAQ.htm"}, method = RequestMethod.GET)
	public String getFaq(ModelMap model){
		String path = "resources/faq.jsp";
		System.out.println(path);
		System.out.println(ClassLoader.getSystemResource(path));
		FileSystemResource resource = new FileSystemResource("/WEB-INF/files/faq.jsp");
		try {
			System.out.println(resource.contentLength());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.put("faq", ClassLoader.getSystemResource(path));
		return "faqEditor";
	}
}