package eacommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eaecommerce.pojo.User;
import eaecommerce.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public void add(User user) {
		userDao.insert(user);
		
		// e la aop??
		System.out.println("User added");
	}
	
	@Override
	public void delete(User user) {
		userDao.delete(user.getId());
		
		// e la aop??
		System.out.println("User deleted");
	}

}
