package aeecommerce.web;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.servlet.ServletContext;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import aeecommerce.pojo.Amministratore;
import aeecommerce.service.UserService;


@Controller
@RequestMapping(value = "/gestioneInfo.htm")
public class UploadController
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
		return "adminInfo";
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
			return "adminInfo/uploadForm";
		}

		// Some type of file processing...
		System.err.println("-------------------------------------------");
		System.err.println("Test upload: " + uploadItem.getName());
		System.err.println("Test upload: " + uploadItem.getFileData().getOriginalFilename());
		System.err.println("-------------------------------------------");
		System.out.println(servletContext.getContextPath());
		System.out.println(servletContext.getRealPath("/"));
		try {
			RandomAccessFile file = new RandomAccessFile(new File(servletContext.getRealPath("/") + uploadItem.getName()), "rw");
			file.write(uploadItem.getFileData().getBytes());
			file.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect:home.htm";
	}
}