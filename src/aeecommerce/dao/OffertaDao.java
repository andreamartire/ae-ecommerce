package aeecommerce.dao;

import java.util.List;

import aeecommerce.pojo.Offerta;

public interface OffertaDao {
	public void insert(Offerta u);
	public void update(Offerta u);
	public void delete(Offerta u);
	public void delete(int id);
	public Offerta findByID(int id); 
	public List<Offerta> findAll();  
	public int count();

}
