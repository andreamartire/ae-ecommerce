package aeecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aeecommerce.dao.AziendaDao;
import aeecommerce.dao.PrivatoDao;
import aeecommerce.pojo.Azienda;
import aeecommerce.pojo.Privato;
import aeecommerce.pojo.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private PrivatoDao privatoDao;
	
	@Autowired
	private AziendaDao aziendaDao;

	@Override
	public void insert(User user) {
		if(Privato.class == user.getClass())
			privatoDao.insert((Privato) user);
		if(Azienda.class == user.getClass())
			aziendaDao.insert((Azienda) user);
		
		System.out.println("User added");
	}
	
	@Override
	public void delete(int id) {
		if(privatoDao.findById(id) != null)
			privatoDao.delete(id);
		if(aziendaDao.findById(id) != null)
			aziendaDao.delete(id);
		
		System.out.println("User deleted");
	}

	@Override
	public void update(User user) {
		if(Privato.class == user.getClass())
			privatoDao.update((Privato) user);
		if(Azienda.class == user.getClass())
			aziendaDao.update((Azienda) user);
		System.out.println("User updated");
	}

	@Override
	public User findByUsername(String username) {
		if(privatoDao.findByUsername(username) != null)
			return privatoDao.findByUsername(username);
		if(aziendaDao.findByUsername(username) != null)
			return aziendaDao.findByUsername(username);
		return null;
	}

	@Override
	public User findById(int id) {
		if(privatoDao.findById(id) != null)
			return privatoDao.findById(id);
		if(aziendaDao.findById(id) != null)
			return aziendaDao.findById(id);
		return null;
	}
}
