package aeecommerce.service;

import java.util.List;

import aeecommerce.pojo.TipoSpedizione;

public interface TipoSpedizioneService {
	public void insert(TipoSpedizione c);
	public void delete(TipoSpedizione c);
	public void delete(int id);
	public void update(TipoSpedizione c);
	public List<TipoSpedizione> list();
	public TipoSpedizione findById(int id);
}
