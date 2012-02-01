package dao;

import java.util.List;

import pojo.Ordine;

public interface OrdineDao {

	public void insert(Ordine p);
	public void update(Ordine p);
	public void delete(int id);
	public Ordine findByID(int id); 
	public List<Ordine> findAll();  
	public int count();
}
