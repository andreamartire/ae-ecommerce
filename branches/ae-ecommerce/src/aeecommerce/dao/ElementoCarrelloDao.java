package aeecommerce.dao;

import java.util.List;

import aeecommerce.pojo.ElementoCarrello;;

public interface ElementoCarrelloDao {
	public void insert(ElementoCarrello u);
	public void update(ElementoCarrello u);
	public void delete(ElementoCarrello u);
	public void delete(int id);
	public ElementoCarrello findByID(int id); 
	public List<ElementoCarrello> findAll();  
	public int count();
}
