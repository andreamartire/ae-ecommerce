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
		
		for(User u: userDao.findAllUsers()){
			System.out.println("User " + u);
			userDao.delete(u);
		}
	}
}
