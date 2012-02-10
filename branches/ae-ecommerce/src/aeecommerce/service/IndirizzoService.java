package aeecommerce.service;

import java.util.List;

import aeecommerce.pojo.Indirizzo;

public interface IndirizzoService {

	public void insert(Indirizzo i);
	public void update(Indirizzo i);
	public void delete(int id);
	public Indirizzo findById(int id);
	public List<Indirizzo> findAll();
}
