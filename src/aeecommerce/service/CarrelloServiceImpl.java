package aeecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		c.removeElementoCarrello(elementoCarrello);
		ecDao.delete(elementoCarrello);
	}

}
