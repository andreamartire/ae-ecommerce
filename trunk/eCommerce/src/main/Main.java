package main;


import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pojo.User;
import dao.UserDao;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		UserDao userDao = (UserDao) context.getBean("userDao");
		User user = (User) context.getBean("user");
		System.out.println(user);
		userDao.insert(user);
		userDao.insert(user);
		userDao.insert(user);
		userDao.delete(new User(2));
		
		List<User> users = userDao.findAllUsers();
		
		for(User u: users)
			System.out.println("User " + u);
		
		User u9 = userDao.findByID(9);
		System.out.println(u9);
	}
}
