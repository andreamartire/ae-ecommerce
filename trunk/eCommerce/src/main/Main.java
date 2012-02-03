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
	static PrivatoDao privatoDao;
	static TipoSpedizioneDao tipoSpedizioneDao;
	static OrdineDao ordineDao;
	static ModalitaPagamentoDao modalitaPagamentoDao;
	static CarrelloDao carrelloDao;

	static ApplicationContext context;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("beans.xml");
		userDao = (UserDao) context.getBean("userDao");
		recapitoDao = (RecapitoDao) context.getBean("recapitoDao");
		indirizzoDao = (IndirizzoDao) context.getBean("indirizzoDao");
		aziendaDao = (AziendaDao) context.getBean("aziendaDao");
		privatoDao = (PrivatoDao) context.getBean("privatoDao");
		tipoSpedizioneDao = (TipoSpedizioneDao) context.getBean("tipoSpedizioneDao");
		modalitaPagamentoDao = (ModalitaPagamentoDao) context.getBean("modalitaPagamentoDao");
		ordineDao = (OrdineDao) context.getBean("ordineDao");
		carrelloDao = (CarrelloDao) context.getBean("carrelloDao");
		
		testUsers();
		testClienti();
		testOrdini();
	}

	@SuppressWarnings("deprecation")
	private static void testOrdini() {
		// aggiungo un utente che effettuera l'ordine
		Privato cliente = new Privato("panunzio76", "dottorpanunzio", new Date(new java.util.Date().getTime()));
		cliente.setNome("giuseppe");
		cliente.setCognome("panunzio");
		cliente.setCodiceFiscale("pnngpp76c23b319c");
		cliente.setDataNascita(new Date("12/10/1976"));
		cliente.setLuogoNascita("palermo");
		Recapito r3 = new Recapito("3206559889", Recapito.CELLULARE);
		Recapito r4 = new Recapito("panunzio@gmail.com", Recapito.EMAIL);
		cliente.addRecapito(r3);
		cliente.addRecapito(r4);
		Indirizzo i3 = new Indirizzo("via roma", "99", "parlemo", "PA", "54400");
		cliente.addIndirizzo(i3);
		userDao.insert(cliente);
		
		// creo una modalita di pagamento
		ModalitaPagamento paypal = new ModalitaPagamento();
		paypal.setNome("PayPal");
		paypal.setDescrizione("Sistema di pagamento online sicuro");
		paypal.setCommissioni(3.4);
		modalitaPagamentoDao.insert(paypal);
		// creo un tipo di spedizione
		TipoSpedizione corriere = new TipoSpedizione();
		corriere.setNome("Corriere");
		corriere.setDescrizione("Spedizione in corriere espresso");
		corriere.setPrezzoBase(9.90);
		tipoSpedizioneDao.insert(corriere);
		
		// creo il carrello
		Carrello carrello1 = new Carrello();
		carrello1.setDataCreazione(new Date());
		carrello1.setCliente(cliente);
		
		// creo un ordine
		Ordine ordine1 = new Ordine();
		ordine1.setData(new Date());
		ordine1.setPesoTotaleApprossimato(10);
		ordine1.setTotaleDaPagare(499.00);
		ordine1.setTipoSpedizione(corriere);
		ordine1.setModalitaPagamento(paypal);
		
		// collego ordine e carrello
		ordine1.setCarrello(carrello1);
		carrello1.setOrdine(ordine1);
		
		ordineDao.insert(ordine1); // in cascata inserisce anche il carrello...
		
		// aggiungo questo carrello alla lista dei carrelli dell'utente
		cliente.addCarrello(carrello1);
		
		// visualizzo e cancello tutto...
		System.out.println("\n\nElenco ordini dell'utente: " + cliente + "\n");
		for (Carrello cc : cliente.getCarrelli()) {
			System.out.println(cc.getOrdine());
			ordineDao.delete(cc.getOrdine()); // in cascata dovrebbe cancellare anche il carrello..
		}
		userDao.delete(cliente);
	}
	
	@SuppressWarnings("deprecation")
	private static void testClienti() {
		Azienda az = new Azienda("azienda1", "pass", new Date(new java.util.Date().getTime()));
		az.setPiva("31213123123");
		az.setRagioneSociale("IT6456457455");
		Recapito r1 = new Recapito("955557897895", Recapito.CELLULARE);
		Recapito r2 = new Recapito("asdas@asddas.org", Recapito.EMAIL);
		az.addRecapito(r1);
		az.addRecapito(r2);
		Indirizzo i1 = new Indirizzo("via roma", "99", "cosenza", "CS", "87100");
		Indirizzo i2 = new Indirizzo("via del castello", "1", "caccuri", "KR", "87101");
		az.addIndirizzo(i1);
		az.addIndirizzo(i2);
		userDao.insert(az);
		
		Privato p = new Privato("privato1", "pass", new Date(new java.util.Date().getTime()));
		p.setNome("mionome");
		p.setCognome("micognome");
		p.setCodiceFiscale("svgrrt56g23b319c");
		p.setDataNascita(new Date("10/10/2010"));
		p.setLuogoNascita("amsterdam");
		Recapito r3 = new Recapito("955557897895", Recapito.CELLULARE);
		Recapito r4 = new Recapito("asdas@asddas.org", Recapito.EMAIL);
		p.addRecapito(r3);
		p.addRecapito(r4);
		Indirizzo i3 = new Indirizzo("via roma", "99", "cosenza", "CS", "87100");
		Indirizzo i4 = new Indirizzo("via del castello", "1", "caccuri", "KR", "87101");
		p.addIndirizzo(i3);
		p.addIndirizzo(i4);
		userDao.insert(p);
		
		for (User u : userDao.findAll()) {
			if (u instanceof Azienda) {
				System.out.println("Azienda: " + (Azienda) u);
			}
			if (u instanceof Privato) {
				System.out.println("Privato: " + (Privato) u);
			}
			userDao.delete(u);
		}
	}

	private static void testUsers() {
		System.out.println("Initial user count " + userDao.count());

		for(User u: userDao.findAll()){
			System.out.println("User deleted " + u);
			userDao.delete(u.getId());
		}

		User user1 = new Privato("user1", "pass1", new Date(new java.util.Date().getTime()));
		User user2 = new Privato("user2", "pass2", new Date(new java.util.Date().getTime()));
		User user3 = new Azienda("user3", "pass3", new Date(new java.util.Date().getTime()));

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

		User userById = userDao.findByID(userDao.findAll().get(0).getId());
		System.out.println("UserByID Before " + userById);
		userById.setUsername("hello");
		System.out.println("UserByID After " + userById);
		userDao.update(userById);
		
		System.out.println("UserByID into the DB " + userDao.findByID(userById.getId()));

		user1.getRecapiti().remove(r1);
		recapitoDao.delete(r1.getId());
		
		r2.setValore("changed");
		recapitoDao.update(r2);
		
		System.out.println("User count: " + userDao.count());
		
		Indirizzo i1 = new Indirizzo("via roma", "99", "cosenza", "CS", "87100");
		Indirizzo i2 = new Indirizzo("via del castello", "1", "caccuri", "KR", "87101");
		user1.addIndirizzo(i1);
		user1.addIndirizzo(i2);
		
		userDao.update(user1);
		
		for (User u : userDao.findAll()) {
			userDao.delete(u);
		}
		
		// testing metodo spedizione
		TipoSpedizione corriere = new TipoSpedizione();
		corriere.setNome("Corriere Espresso");
		corriere.setDescrizione( "Spedizione nazionale tramite corriere espresso SDA\n"+
								 "Tempi di spedizione previsti: 24/48 ore\n" +
								 "Escluso isole e zone disagiate");
		corriere.setPrezzoBase(5.90);
		tipoSpedizioneDao.insert(corriere);
		
		List<TipoSpedizione> metodiSpedizione = tipoSpedizioneDao.findAll();
		System.out.println("\n\nElenco tipi di spedizione\n");
		for(TipoSpedizione m : metodiSpedizione) {
			System.out.println(m);
			tipoSpedizioneDao.delete(m.getId());
		}
		
//		user1.getIndirizzi().remove(i1);
//		userDao.update(user1);
//		indirizzoDao.delete(i1);
//		
//		i2.setCitta("San Francisco");
//		indirizzoDao.update(i2);
	}
}