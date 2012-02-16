package aeecommerce.service;

import aeecommerce.pojo.Carrello;


public interface CarrelloService {

	public void aggiungi(int idProdotto, int qnt, Carrello c);
	
	public void remove(int elementoCarrello, Carrello c);
}
