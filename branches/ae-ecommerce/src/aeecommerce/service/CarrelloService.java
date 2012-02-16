package aeecommerce.service;

import aeecommerce.pojo.Carrello;


public interface CarrelloService {

	public void aggiungi(int idProdotto, int qnt, Carrello c);
	
	public void remove(int elementoCarrello, Carrello c);

	void save(Carrello c);

	public void update(int elementoCarrello, int qnt);
}
