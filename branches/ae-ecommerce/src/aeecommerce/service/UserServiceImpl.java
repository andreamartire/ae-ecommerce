package aeecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aeecommerce.dao.UserDao;
import aeecommerce.pojo.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public void insert(User user) {
		userDao.insert(user);
		System.out.println("User added");
	}
	
	@Override
	public void delete(int id) {
		userDao.delete(id);
		System.out.println("User deleted");
	}

	@Override
	public void update(User user) {
		userDao.update(user);
		System.out.println("User updated");
	}

	@Override
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	public User findById(int id) {
		return userDao.findByID(id);
	}
}
