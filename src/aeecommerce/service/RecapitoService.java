package aeecommerce.service;

import java.util.List;

import aeecommerce.pojo.Recapito;

public interface RecapitoService {

	public void insert(Recapito i);
	public void update(Recapito i);
	public void delete(int id);
	public Recapito findById(int id);
	public List<Recapito> findAll();
}
