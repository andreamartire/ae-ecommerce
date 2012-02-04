package aeecommerce.dao;

import java.util.List;

import aeecommerce.pojo.Prodotto;

public interface ProdottoDao {
	public void insert(Prodotto u);
	public void update(Prodotto u);
	public void delete(Prodotto u);
	public void delete(int id);
	public Prodotto findByID(int id); 
	public List<Prodotto> findAll();  
	public int count();
}
