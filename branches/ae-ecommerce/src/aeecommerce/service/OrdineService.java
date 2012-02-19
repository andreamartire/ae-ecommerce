package aeecommerce.service;

import java.util.List;

import aeecommerce.pojo.Ordine;

public interface OrdineService {

	public void insert(Ordine o);
	public void delete(Ordine o);
	public void delete(int id);
	public void update(Ordine o);
	public List<Ordine> list();
	public Ordine findById(int id);
}
