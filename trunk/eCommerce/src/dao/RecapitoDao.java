package dao;

import java.util.List;

import pojo.Recapito;

public interface RecapitoDao {

	public void update(Recapito r);
	public void delete(int id);
	public Recapito findById(int id);
	public List<Recapito> findAllRecapito();
	public int recapitoCount();
}
