package aeecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aeecommerce.dao.AziendaDao;
import aeecommerce.pojo.Azienda;

@Service
public class AziendaServiceImpl implements AziendaService {

	@Autowired
	private AziendaDao aziendaDao;
	
	public void setUserDao(AziendaDao aziendaDao) {
		this.aziendaDao = aziendaDao;
	}

	@Override
	public void insert(Azienda user) {
		aziendaDao.insert(user);
		
		// e la aop??
		System.out.println("Azienda added");
	}
	
	@Override
	public void delete(int id) {
		aziendaDao.delete(id);
		
		// e la aop??
		System.out.println("Azienda deleted");
	}

	@Override
	public void update(Azienda u) {
		aziendaDao.update(u);
		System.out.println("Azienda updated");
	}

	@Override
	public Azienda findByUsername(String username) {
		System.out.println("find Azienda " + username);
		return aziendaDao.findByUsername(username);
	}

	@Override
	public Azienda findById(int userId) {
		return aziendaDao.findById(userId);
	}
}
