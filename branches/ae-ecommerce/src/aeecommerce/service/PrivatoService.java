package aeecommerce.service;

import aeecommerce.pojo.Privato;

public interface PrivatoService {

	public void insert(Privato u);
	public void update(Privato u);
	public void delete(int id);
	public Privato findByUsername(String username);
	public Privato findById(int userId); 
}
