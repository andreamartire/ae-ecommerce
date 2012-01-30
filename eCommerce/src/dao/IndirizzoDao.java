package dao;

import java.util.List;

import pojo.Indirizzo;
import pojo.Recapito;

public interface IndirizzoDao {

	public void update(Indirizzo r);
	public void delete(int id);
	public Indirizzo findById(int id);
	public List<Indirizzo> findAllIndirizzo();
	public int indirizzoCount();
}
