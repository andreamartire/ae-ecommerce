package aeecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aeecommerce.dao.IndirizzoDao;
import aeecommerce.pojo.Indirizzo;

@Service
public class IndirizzoServiceImpl implements IndirizzoService {
	
	@Autowired
	private IndirizzoDao indirizzoDao;
	
	@Override
	public void delete(int id) {
		indirizzoDao.delete(id);
		System.out.println("Indirizzo deleted");
	}

	@Override
	public void update(Indirizzo Indirizzo) {
		indirizzoDao.update(Indirizzo);
		System.out.println("Indirizzo updated");
	}

	@Override
	public Indirizzo findById(int id) {
		return indirizzoDao.findById(id);
	}

	@Override
	public List<Indirizzo> findAll() {
		return indirizzoDao.findAll();
	}

	@Override
	public void insert(Indirizzo i) {
		indirizzoDao.insert(i);
	}

}
