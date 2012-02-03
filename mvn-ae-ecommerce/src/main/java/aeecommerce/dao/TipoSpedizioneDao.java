package aeecommerce.dao;


import java.util.List;

import aeecommerce.pojo.TipoSpedizione;


public interface TipoSpedizioneDao {
	public void insert(TipoSpedizione m);
	public void update(TipoSpedizione m);
	public void delete(TipoSpedizione m);
	public void delete(int id);
	public TipoSpedizione findById(int id);
	public List<TipoSpedizione> findAll();
	public int count();
}
