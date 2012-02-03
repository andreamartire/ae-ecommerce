package aeecommerce.dao;

import java.util.List;

import aeecommerce.pojo.Ordine;


public interface OrdineDao {

	public void insert(Ordine p);
	public void update(Ordine p);
	public void delete(Ordine o);
	public void delete(int id);
	public Ordine findByID(int id); 
	public List<Ordine> findAll();  
	public int count();
}
