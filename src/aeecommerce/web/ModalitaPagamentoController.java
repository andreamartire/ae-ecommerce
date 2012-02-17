package aeecommerce.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import aeecommerce.pojo.ModalitaPagamento;
import aeecommerce.service.ModalitaPagamentoService;

@Controller
public class ModalitaPagamentoController {

	@Autowired
	ModalitaPagamentoService modalitaPagamentoService;
	
	@RequestMapping(value = "/gestioneModalitaPagamento.htm", method = RequestMethod.GET)
	public String gestioneSpedizioni(ModelMap model) {
		
		List<ModalitaPagamento> listaModalita = modalitaPagamentoService.list();
		List<ModalitaPagamento> list = new ArrayList<ModalitaPagamento>();
		
		for (ModalitaPagamento p : listaModalita)
			list.add(p);
		
		model.put("listaModalita", list);
		
		return "modalitaPagamentoManagement";
	}
	
	@RequestMapping(value = "/aggiungiModalitaPagamento.htm", method = RequestMethod.POST)
	public @ResponseBody String aggiungiModalitaPagamento(HttpServletRequest model) {
		
		System.out.println("aggiungo ModalitaPagamento " + model.getParameter("nome")); 
		
		ModalitaPagamento p = new ModalitaPagamento();
		p.setNome((String) model.getParameter("nome"));
		p.setDescrizione(model.getParameter("descrizione"));
		p.setCommissioni(Double.parseDouble(model.getParameter("commissioni")));
		System.out.println(p);
		modalitaPagamentoService.insert(p);
		
		return "ModalitaPagamento " + model.getParameter("nome") + " aggiunto";
	}
	
	@RequestMapping(value = "/eliminaModalitaPagamento.htm", method = RequestMethod.POST)
	public @ResponseBody String eliminaModalitaPagamento(@RequestParam int idModalitaPagamento) {
		
		ModalitaPagamento p = modalitaPagamentoService.findById(idModalitaPagamento);
		modalitaPagamentoService.delete(p);
		
		return "ModalitaPagamento " + idModalitaPagamento ;
	}
	
	@RequestMapping(value = "/modificaModalitaPagamento.htm", method = RequestMethod.POST)
	public @ResponseBody String modificaModalitaPagamento(HttpServletRequest model) {
		
		ModalitaPagamento p = modalitaPagamentoService.findById(Integer.parseInt(model.getParameter("idModalitaPagamento")));
		
		p.setNome((String) model.getParameter("nome"));
		p.setDescrizione(model.getParameter("descrizione"));
		p.setCommissioni(Double.parseDouble(model.getParameter("commissioni")));
		
		modalitaPagamentoService.update(p);
		
		return "ok";
	}
}
