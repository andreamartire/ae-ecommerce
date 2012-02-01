package main;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pojo.*;
import dao.*;

public class Main {

	static UserDao userDao;
	static RecapitoDao recapitoDao;
	static IndirizzoDao indirizzoDao;
	static AziendaDao aziendaDao;
	static MetodoSpedizioneDao metodoSpedizioneDao;

	static ApplicationContext context;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("beans.xml");
		userDao = (UserDao) context.getBean("userDao");
		recapitoDao = (RecapitoDao) context.getBean("recapitoDao");
		indirizzoDao = (IndirizzoDao) context.getBean("indirizzoDao");
		aziendaDao = (AziendaDao) context.getBean("aziendaDao");
		metodoSpedizioneDao = (MetodoSpedizioneDao) context.getBean("metodoSpedizioneDao");

//		testUsers();
		testClienti();
	}

	private static void testClienti() {
		Azienda az = new Azienda("azienda", "pass", new Date("12/12/2001"));
		az.setPiva("31213123123");
		az.setRagioneSociale("dasd ad das asd das");
		aziendaDao.insert(az);
	}

	private static void testUsers() {
		System.out.println("Initial user count " + userDao.userCount());

		for(User u: userDao.findAllUsers()){
			System.out.println("User deleted " + u);
			userDao.delete(u.getId());
		}

		User user1 = new User("user1", "pass1", new Date("12/12/2001"));
		User user2 = new User("user2", "pass2", new Date("12/12/2001"));
		User user3 = new User("user3", "pass3", new Date("12/12/2001"));

		Recapito r1 = new Recapito("955557897895", Recapito.CELLULARE);
		Recapito r2 = new Recapito("asdas@asddas.org", Recapito.EMAIL);
		user1.addRecapito(r1);
		user1.addRecapito(r2);

		System.out.println("Insert " + user1);
		userDao.insert(user1);

		System.out.println("Insert " + user2);
		userDao.insert(user2);

		System.out.println("Insert " + user3);
		userDao.insert(user3);

		User userById = userDao.findByID(userDao.findAllUsers().get(0).getId());
		System.out.println("UserByID Before " + userById);
		userById.setUsername("hello");
		System.out.println("UserByID After " + userById);
		userDao.update(userById);
		
		System.out.println("UserByID into the DB " + userDao.findByID(userById.getId()));

		user1.getRecapiti().remove(r1);
		recapitoDao.delete(r1.getId());
		
		r2.setValore("changed");
		recapitoDao.update(r2);
		
		System.out.println("User count: " + userDao.userCount());
		
		Indirizzo i1 = new Indirizzo("via roma", "99", "cosenza", "CS", "87100");
		Indirizzo i2 = new Indirizzo("via del castello", "1", "caccuri", "KR", "87101");
		user1.addIndirizzo(i1);
		user1.addIndirizzo(i2);
		
		userDao.update(user1);
		
		
		
		// testing metodo spedizione
		MetodoSpedizione corriere = new MetodoSpedizione();
		corriere.setNome("Corriere Espresso");
		corriere.setDescrizione( "Spedizione nazionale tramite corriere espresso SDA\n"+
								 "Tempi di spedizione previsti: 24/48 ore\n" +
								 "Escluso isole e zone disagiate");
		corriere.setPrezzoBase("5.90 euro");
		metodoSpedizioneDao.insert(corriere);
		
		List<MetodoSpedizione> metodiSpedizione = metodoSpedizioneDao.findAll();
		for(MetodoSpedizione m : metodiSpedizione) {
			System.out.println(m);
			metodoSpedizioneDao.delete(m.getId());
		}
		
//		user1.getIndirizzi().remove(i1);
//		userDao.update(user1);
//		indirizzoDao.delete(i1);
//		
//		i2.setCitta("San Francisco");
//		indirizzoDao.update(i2);
	}
}