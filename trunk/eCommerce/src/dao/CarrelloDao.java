package dao;

import java.util.List;

import pojo.Carrello;

public interface CarrelloDao {

	public void insert(Carrello u);
	public void update(Carrello u);
	public void delete(Carrello u);
	public void delete(int id);
	public Carrello findByID(int id); 
	public List<Carrello> findAll();  
	public int count();
}
