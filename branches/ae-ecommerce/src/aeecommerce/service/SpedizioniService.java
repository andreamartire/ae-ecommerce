package aeecommerce.service;

import java.util.List;

import aeecommerce.pojo.TipoSpedizione;

public interface SpedizioniService {

	public void insert(TipoSpedizione i);
	public void update(TipoSpedizione i);
	public void delete(int id);
	public TipoSpedizione findById(int id);
	public List<TipoSpedizione> findAll();
}
