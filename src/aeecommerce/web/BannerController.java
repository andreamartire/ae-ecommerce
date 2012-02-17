package aeecommerce.web;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import aeecommerce.pojo.UploadItem;
import aeecommerce.service.UserService;


@Controller
@RequestMapping(value = "/gestioneInfo.htm")
public class BannerController
{
	@Autowired
	UserService userService;
	
	@Autowired
	ServletContext servletContext;

	
	@RequestMapping(method = RequestMethod.GET)
	public String getUploadForm(Model model)
	{
		System.out.println("Upload get");
		model.addAttribute(new UploadItem());
		return "bannerEditor";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String create(UploadItem uploadItem, BindingResult result)
	{
		if (result.hasErrors())
		{
			for(ObjectError error : result.getAllErrors())
			{
				System.err.println("Error: " + error.getCode() +  " - " + error.getDefaultMessage());
			}
			return "bannerEditor/uploadForm";
		}

		try {
			RandomAccessFile file = new RandomAccessFile(
					new File(servletContext.getRealPath("/") + "resources/images/banner.jpg"), "rw");
			file.write(uploadItem.getFileData().getBytes());
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "redirect:home.htm";
	}
}