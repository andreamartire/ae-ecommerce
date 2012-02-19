package aeecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aeecommerce.dao.OrdineDao;
import aeecommerce.pojo.Ordine;

@Service
public class OrdineServiceImpl implements OrdineService {
	
	@Autowired
	OrdineDao ordineDao;
	
	@Override
	public List<Ordine> list() {
		return ordineDao.findAll();
	}

	@Override
	public void insert(Ordine c) {
		ordineDao.insert(c);
	}

	@Override
	public void delete(Ordine c) {
		ordineDao.delete(c);
	}

	@Override
	public void update(Ordine c) {
		ordineDao.update(c);
	}

	@Override
	public void delete(int id) {
		ordineDao.delete(ordineDao.findByID(id));
	}

	@Override
	public Ordine findById(int id) {
		return ordineDao.findByID(id);
	}

}
