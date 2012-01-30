package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pojo.*;
import dao.*;

public class Main {

	static UserDao userDao;
	static RecapitoDao recapitoDao;
	static IndirizzoDao indirizzoDao;
	static ApplicationContext context;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("beans.xml");
		userDao = (UserDao) context.getBean("userDao");
		recapitoDao = (RecapitoDao) context.getBean("recapitoDao");
		indirizzoDao = (IndirizzoDao) context.getBean("indirizzoDao");

		testUsers();
	}

	private static void testUsers() {
		System.out.println("Initial user count " + userDao.userCount());

		for(User u: userDao.findAllUsers()){
			System.out.println("User deleted " + u);
			userDao.delete(u);
		}

		User user1 = (User) context.getBean("user1");
		User user2 = (User) context.getBean("user2");
		User user3 = (User) context.getBean("user3");

		System.out.println("Insert " + user1);

		Recapito r1 = new Recapito("955557897895", Recapito.CELLULARE);
		Recapito r2 = new Recapito("asdas@asddas.org", Recapito.EMAIL);
		user1.addRecapito(r1);
		user1.addRecapito(r2);

		userDao.insert(user1);

		System.out.println("Insert " + user2);
		userDao.insert(user2);

		System.out.println("Insert " + user3);
		userDao.insert(user3);

//		User userById = userDao.findByID(userDao.findAllUsers().get(0).getId());
//		System.out.println("UserByID " + userById);
//		userById.setUsername("hello");
//		userDao.update(userById);
//		System.out.println("Updated Local " + userById);
//		System.out.println("Updated DB " + userDao.findByID(userById.getId()));
//		
//		user1.getRecapiti().remove(r1);
//		userDao.update(user1);
//		recapitoDao.delete(r1);
//		
//		r2.setValore("changed");
//		recapitoDao.update(r2);
		
		System.out.println("User count: " + userDao.userCount());
		
		Indirizzo i1 = new Indirizzo("via roma", "99", "cosenza", "CS", "87100");
		Indirizzo i2 = new Indirizzo("via del castello", "1", "caccuri", "KR", "87101");
		user1.addIndirizzo(i1);
		user1.addIndirizzo(i2);
		
		userDao.update(user1);
//		
//		user1.getIndirizzi().remove(i1);
//		userDao.update(user1);
//		indirizzoDao.delete(i1);
//		
//		i2.setCitta("San Francisco");
//		indirizzoDao.update(i2);
	}
}