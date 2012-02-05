package aeecommerce.service;

import aeecommerce.pojo.Azienda;

public interface AziendaService {

	public void insert(Azienda a);
	public void update(Azienda a);
	public void delete(int id);
	public Azienda findByUsername(String username); 
}
