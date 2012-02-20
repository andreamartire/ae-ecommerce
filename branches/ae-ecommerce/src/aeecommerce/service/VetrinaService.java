package aeecommerce.service;

import aeecommerce.pojo.Vetrina;

public interface VetrinaService {

	public void update(Vetrina d);

	public Vetrina load();

	public void save(Vetrina Vetrina);

	public void delete(Vetrina vetrina);

	public void deleteProdotto(int idProdotto);
}

