package aeecommerce.service;

import java.util.List;

import aeecommerce.pojo.Carrello;
import aeecommerce.pojo.ElementoCarrello;


public interface CarrelloService {

	public void aggiungi(int idProdotto, int qnt, Carrello c);
	
	public void remove(int elementoCarrello, Carrello c);

	void save(Carrello c);

	public void update(int elementoCarrello, int qnt);

	public List<ElementoCarrello> list(Carrello carrello);
}
