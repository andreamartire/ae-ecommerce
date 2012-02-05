package aeecommerce.dao;

import java.util.List;

import aeecommerce.pojo.Privato;


public interface PrivatoDao {

	public void insert(Privato p);
	public void update(Privato p);
	public void delete(int id);
	public Privato findByUsername(String username); 
	public List<Privato> findAll();  
	public int count();
}
