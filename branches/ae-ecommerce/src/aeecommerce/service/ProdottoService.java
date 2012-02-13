package aeecommerce.service;

import java.util.List;

import aeecommerce.pojo.Prodotto;

public interface ProdottoService {
	public void insert(Prodotto c);
	public void delete(Prodotto c);
	public void delete(int id);
	public void update(Prodotto c);
	public List<Prodotto> list();
//	public Prodotto findByName(String parentString);
	public Prodotto findById(int id);
}
