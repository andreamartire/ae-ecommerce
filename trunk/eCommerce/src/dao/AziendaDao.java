package dao;

import java.util.List;

import pojo.Azienda;

public interface AziendaDao {

	public void insert(Azienda a);
	public void update(Azienda a);
	public void delete(int id);
	public Azienda findByID(int id); 
	public List<Azienda> findAllUsers();  
	public int userCount();
}
