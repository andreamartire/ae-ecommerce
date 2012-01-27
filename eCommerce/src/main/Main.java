package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pojo.Recapito;
import pojo.User;
import dao.UserDao;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		UserDao userDao = (UserDao) context.getBean("userDao");
		
		System.out.println("Initial user count " + userDao.userCount());
		
		for(User u: userDao.findAllUsers()){
			System.out.println("User deleted " + u);
			userDao.delete(u);
		}
		
		User user1 = (User) context.getBean("user1");
		User user2 = (User) context.getBean("user2");
		User user3 = (User) context.getBean("user3");
		
		System.out.println("Insert " + user1);
		
		user1.getRecapiti().add(new Recapito("955557897895", Recapito.Tipo.CELLULARE));
		user1.getRecapiti().add(new Recapito("asdas@asddas.org", Recapito.Tipo.EMAIL));
		
		userDao.insert(user1);
		
		System.out.println("Insert " + user2);
		userDao.insert(user2);
		
		System.out.println("Insert " + user3);
		userDao.insert(user3);
		
		User userById = userDao.findByID(userDao.findAllUsers().get(0).getId());
		System.out.println("UserByID " + userById);
		userById.setUsername("hello");
		userDao.update(userById);
		System.out.println("Updated Local " + userById);
		System.out.println("Updated DB " + userDao.findByID(userById.getId()));
		
		System.out.println("User count: " + userDao.userCount());
		
//		for(User u: userDao.findAllUsers()){
//			System.out.println("User deleted " + u);
//			userDao.delete(u);
//		}
	}
}