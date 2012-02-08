package aeecommerce.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import aeecommerce.pojo.Azienda;
import aeecommerce.pojo.Privato;
import aeecommerce.pojo.User;

@Component
public class UserHibernateDao extends MasterDao implements UserDao {

	public void insert(User u) {
		if(Privato.class == u.getClass())
			getHibernateTemplate().save((Privato) u);
		if(Azienda.class == u.getClass())
			getHibernateTemplate().save((Azienda) u);
	}

	public void update(User u) {
		if(Privato.class == u.getClass())
			getHibernateTemplate().update((Privato) u);
		if(Azienda.class == u.getClass())
			getHibernateTemplate().update((Azienda) u);
	}
	
	public void delete(User u){
		if(Privato.class == u.getClass())
			getHibernateTemplate().delete((Privato) u);
		if(Azienda.class == u.getClass())
			getHibernateTemplate().delete((Azienda) u);
	}

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
	}

	public User findByID(int id) {
		if(getHibernateTemplate().get(Privato.class, id) != null)
			return getHibernateTemplate().get(Privato.class,id);
		if(getHibernateTemplate().get(Azienda.class, id) != null)
			return getHibernateTemplate().get(Azienda.class,id);
		return null;
	}
	
	public User findByUsername(String username) {
		@SuppressWarnings("unchecked")
		List<User> userList = getHibernateTemplate().findByExample(new User(username,null,null));
		if(userList != null && !userList.isEmpty()){
			int id = userList.get(0).getId();
			if(getHibernateTemplate().get(Privato.class, id) != null)
				return getHibernateTemplate().get(Privato.class,id);
			if(getHibernateTemplate().get(Azienda.class, id) != null)
				return getHibernateTemplate().get(Azienda.class,id);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Privato> findAllPrivato() {
		return getHibernateTemplate().find("from Privato");
	}
	
	@SuppressWarnings("unchecked")
	public List<Azienda> findAllAzienda() {
		return getHibernateTemplate().find("from Azienda");
	}

	@Override
	public int countPrivato() {
		return findAllPrivato().size();
	}
	
	@Override
	public int countAzienda() {
		return findAllAzienda().size();
	}
}
