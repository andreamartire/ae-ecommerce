package aeecommerce.dao;

import java.util.List;

import aeecommerce.pojo.Indirizzo;


public interface IndirizzoDao {

	public void update(Indirizzo r);
	public void delete(int id);
	public void delete(Indirizzo r);
	public Indirizzo findById(int id);
	public List<Indirizzo> findAll();
	public int count();
	public void insert(Indirizzo i);
}
