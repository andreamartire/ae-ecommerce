package eaecommerce.dao;

import java.util.List;

import eaecommerce.pojo.Indirizzo;
import eaecommerce.pojo.Recapito;


public interface IndirizzoDao {

	public void update(Indirizzo r);
	public void delete(int id);
	public Indirizzo findById(int id);
	public List<Indirizzo> findAllIndirizzo();
	public int indirizzoCount();
}
