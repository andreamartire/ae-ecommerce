package dao;


import java.util.List;

import pojo.MetodoSpedizione;

public interface MetodoSpedizioneDao {
	public void insert(MetodoSpedizione m);
	public void update(MetodoSpedizione m);
	public void delete(int id);
	public MetodoSpedizione findById(int id);
	public List<MetodoSpedizione> findAll();
	public int count();
}
