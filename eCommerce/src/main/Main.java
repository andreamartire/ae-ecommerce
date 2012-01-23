package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pojo.User;
import dao.UserDao;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		UserDao userDao = (UserDao) context.getBean("userDao");
		
		for(User u: userDao.findAllUsers()){
			System.out.println("User " + u);
			userDao.delete(u);
		}
		
		User user = (User) context.getBean("user");
		System.out.println(user);
		userDao.insert(user);
		
		user.setId(2);
		System.out.println(user);
		userDao.insert(user);
		
		user.setId(3);
		System.out.println(user);
		userDao.insert(user);
		
		for(User u: userDao.findAllUsers()){
			System.out.println("User " + u);
			userDao.delete(u);
		}
	}
}