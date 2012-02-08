package aeecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aeecommerce.dao.PrivatoDao;
import aeecommerce.pojo.Privato;

@Service
public class PrivatoServiceImpl implements PrivatoService {

	@Autowired
	private PrivatoDao privatoDao;
	
	public void setUserDao(PrivatoDao privatoDao) {
		this.privatoDao = privatoDao;
	}

	@Override
	public void insert(Privato user) {
		privatoDao.insert(user);
		
		// e la aop??
		System.out.println("Privato added");
	}
	
	@Override
	public void delete(int id) {
		privatoDao.delete(id);
		
		// e la aop??
		System.out.println("Privato deleted");
	}

	@Override
	public void update(Privato u) {
		privatoDao.update(u);
		System.out.println("Privato updated");
	}

	@Override
	public Privato findByUsername(String username) {
		System.out.println("find Privato " + username);
		return privatoDao.findByUsername(username);
	}

	@Override
	public Privato findById(int userId) {
		return privatoDao.findById(userId);
	}
}
