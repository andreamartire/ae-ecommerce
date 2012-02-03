package aeecommerce.dao;

import java.util.List;

import aeecommerce.pojo.Privato;


public interface PrivatoDao {

	public void insert(Privato p);
	public void update(Privato p);
	public void delete(int id);
	public Privato findByID(int id); 
	public List<Privato> findAll();  
	public int count();
}
