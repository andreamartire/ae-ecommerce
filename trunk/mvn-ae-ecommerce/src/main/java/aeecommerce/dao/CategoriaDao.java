package aeecommerce.dao;

import java.util.List;

import aeecommerce.pojo.Categoria;

public interface CategoriaDao {
	public void insert(Categoria u);
	public void update(Categoria u);
	public void delete(Categoria u);
	public void delete(int id);
	public Categoria findByID(int id); 
	public List<Categoria> findAll();  
	public int count();
}
