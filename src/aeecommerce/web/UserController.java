package aeecommerce.web;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import aeecommerce.pojo.Azienda;
import aeecommerce.pojo.Carrello;
import aeecommerce.pojo.Cliente;
import aeecommerce.pojo.Privato;
import aeecommerce.pojo.User;
import aeecommerce.service.CarrelloService;
import aeecommerce.service.UserService;

@Controller
@SessionAttributes(value = {"user","type","name","carrello"})
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private CarrelloService carrelloService;
	
	@RequestMapping(value = "/ajaxLogin.htm", method = RequestMethod.POST)
	public @ResponseBody String ajaxLogin(@RequestParam String username, @RequestParam String password, ModelMap model) {
		
		User userDB = userService.findByUsername(username);
		
		if(userDB == null)
			return "{\"name\":\"noUser\",\"type\":\"noUser\"}";
		if(!userDB.getPassword().equals(password))
			return "{\"name\":\"badPassword\",\"type\":\"badPassword\"}";
		
		String name, type;
		if (userDB instanceof Privato) {
			type = "privato";
			name = ((Privato) userDB).getNome();
		}
		else if (userDB instanceof Azienda) {
			type = "azienda";
			name = ((Azienda) userDB).getRagioneSociale();
		}
		else {
			type = "admin";
			name = username;
		}
		
		Carrello c = null;
		if (!type.equals("admin")) {
			List<Carrello> carrelliCliente = ((Cliente) userDB).getCarrelli();
			if(carrelliCliente.size() > 0)
				c = carrelliCliente.get(carrelliCliente.size()-1);
			
			if (c == null) {
				System.out.println("creazione nuovo carrello");
				c = new Carrello();
				c.setDataCreazione(new Date());

				c.setCliente((Cliente) userDB);
				carrelliCliente.add(c);
				
				userService.update(userDB);
				carrelloService.save(c);
			} else {
				System.out.println("carrello gia esistente");
			}
			
			System.out.println(c);
		}
		
		model.put("user", username);
		model.put("name", name);
		model.put("type", type);
		model.put("carrello", c);
		
		System.out.println("login: " + username + " effettuato");
		
		return "{\"name\":\"" + name + "\",\"type\":\"" + type + "\"}";
	}
	
	@RequestMapping(value = "/logout.htm", method = RequestMethod.GET)
	public @ResponseBody String logout(ModelMap model, HttpSession session) {
		String user = (String) session.getAttribute("user");
		System.out.println("logout " + user);
		
		model.put("user", "");
		model.put("name", "");
		model.put("type", "");
		model.put("carrello", "");
		
		return user;
	}
	
	@RequestMapping(value = {"/checkUsername.htm"}, method = RequestMethod.POST)
	public @ResponseBody String ajaxCheckUsername(@RequestParam String username) {
		
		User userDB = userService.findByUsername(username);
		System.out.println(userDB);
		if(userDB == null)
			return "available";
		return "notAvailable";
	}
}