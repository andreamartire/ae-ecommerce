package aeecommerce.dao;

import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import aeecommerce.pojo.Amministratore;
import aeecommerce.pojo.Azienda;
import aeecommerce.pojo.Privato;
import aeecommerce.pojo.User;

@Component
public class UserHibernateDao extends MasterDao implements UserDao {

	@Transactional
	@Override
	public void insert(User u) {
		if(u instanceof Privato)
			getHibernateTemplate().save((Privato) u);
		if(u instanceof Azienda)
			getHibernateTemplate().save((Azienda) u);
		if(u instanceof Amministratore)
			getHibernateTemplate().save((Amministratore) u);
	}

	@Transactional
	@Override
	public void update(User u) {
		if(u instanceof Privato){
			System.out.println("Update privato");
			getHibernateTemplate().update((Privato) u);
		}
		if(u instanceof Azienda){
			System.out.println("Update azienda");
			getHibernateTemplate().update((Azienda) u);
		}
		if(u instanceof Amministratore){
			System.out.println("Update amministratore");
			getHibernateTemplate().save((Amministratore) u);
		}
	}
	
	@Transactional
	@Override
	public void delete(User u){
		if(u instanceof Privato)
			getHibernateTemplate().delete((Privato) u);
		if(u instanceof Azienda)
			getHibernateTemplate().delete((Azienda) u);
		if(u instanceof Amministratore)
			getHibernateTemplate().delete((Amministratore) u);
	}

	@Transactional
	@Override
	public void delete(int id) {
		User user = (User) getHibernateTemplate().get(User.class, id);
		if(getHibernateTemplate().get(Privato.class, id) != null){
			getHibernateTemplate().delete((Privato) user);
			System.out.println("delete privato");
		}
		if(getHibernateTemplate().get(Azienda.class, id) != null){
			getHibernateTemplate().delete((Azienda) user);
			System.out.println("delete azienda");
		}
		if(getHibernateTemplate().get(Amministratore.class, id) != null){
			getHibernateTemplate().delete((Amministratore) user);
			System.out.println("delete amministratore");
		}
	}

	@Transactional
	@Override
	public User findByID(int id) {
		if(getHibernateTemplate().get(Privato.class, id) != null)
			return getHibernateTemplate().get(Privato.class,id);
		if(getHibernateTemplate().get(Azienda.class, id) != null)
			return getHibernateTemplate().get(Azienda.class,id);
		return getHibernateTemplate().get(Amministratore.class, id);
	}
	
	@Transactional
	@Override
	public User findByUsername(String username) {
		@SuppressWarnings("unchecked")
		List<User> userList = getHibernateTemplate().findByExample(new User(username,null,null));
		if(userList != null && !userList.isEmpty()){
			int id = userList.get(0).getId();
			System.out.println("******** "+ id + " **************" );
			if(getHibernateTemplate().get(Privato.class, id) != null)
				return getHibernateTemplate().get(Privato.class,id);
			if(getHibernateTemplate().get(Azienda.class, id) != null)
				return getHibernateTemplate().get(Azienda.class,id);
			return getHibernateTemplate().get(Amministratore.class, id);		
		}
		return null;
	}

	@Transactional
	@Override
	@SuppressWarnings("unchecked")
	public List<Privato> findAllPrivato() {
		return getHibernateTemplate().find("from Privato");
	}
	
	@Transactional
	@Override
	@SuppressWarnings("unchecked")
	public List<Azienda> findAllAzienda() {
		return getHibernateTemplate().find("from Azienda");
	}

	@Transactional
	@Override
	public int countPrivato() {
		return findAllPrivato().size();
	}
	
	@Transactional
	@Override
	public int countAzienda() {
		return findAllAzienda().size();
	}

	@Transactional
	@Override
	public boolean isPrivato(String username) {
		if(getHibernateTemplate().get(Privato.class, findByUsername(username).getId()) != null)
			return true;
		return false;
	}
}
