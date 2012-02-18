package aeecommerce.dao;

import aeecommerce.pojo.Vetrina;

public interface VetrinaDao {

	public void update(Vetrina d);

	public Vetrina load();

	public void insert(Vetrina Vetrina);
}
