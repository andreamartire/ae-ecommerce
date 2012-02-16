package aeecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aeecommerce.dao.CarrelloDao;
import aeecommerce.dao.ElementoCarrelloDao;
import aeecommerce.dao.ProdottoDao;
import aeecommerce.pojo.Carrello;
import aeecommerce.pojo.ElementoCarrello;
import aeecommerce.pojo.Prodotto;

@Service
public class CarrelloServiceImpl implements CarrelloService {

	@Autowired
	ProdottoDao prodottoDao;
	
	@Autowired
	ElementoCarrelloDao ecDao;
	
	@Autowired
	CarrelloDao carrelloDao;
	
	@Override
	public void save(Carrello c) {
		carrelloDao.insert(c);
	}
	
	@Override
	public void aggiungi(int idProdotto, int qnt, Carrello c) {
		ElementoCarrello e = new ElementoCarrello();
		e.setCarrello(c);
		e.setQuantita(qnt);
		Prodotto p = prodottoDao.findByID(idProdotto);
		e.setProdotto(p);
		c.addElementoCarrello(e);
		
		ecDao.insert(e);
	}

	@Override
	public void remove(int elementoCarrello, Carrello c) {
		ElementoCarrello e = ecDao.findByID(elementoCarrello);
		System.out.println(e);
		c.removeElementoCarrello(elementoCarrello);
		ecDao.delete(e);
	}

	@Override
	public void update(int elementoCarrello, int qnt) {
		ElementoCarrello e = ecDao.findByID(elementoCarrello);
		e.setQuantita(qnt);
		ecDao.update(e);
	}

}
