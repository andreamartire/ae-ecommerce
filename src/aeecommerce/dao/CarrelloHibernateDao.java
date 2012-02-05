package aeecommerce.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import aeecommerce.pojo.Carrello;

@Component
public class CarrelloHibernateDao extends HibernateDaoSupport implements CarrelloDao {

	@Autowired
	public void init(SessionFactory factory) {
	    setSessionFactory(factory);
	}
	
	public void insert(Carrello entity) {
		getHibernateTemplate().saveOrUpdate(entity);
	}

	public void update(Carrello entity) {
		getHibernateTemplate().save(entity);
	}

	public void delete(Carrello u) {
		getHibernateTemplate().delete(u);
	}

	public void delete(int id) {
		Carrello carrello = (Carrello) getHibernateTemplate().get(Carrello.class, id);
		getHibernateTemplate().delete(carrello);
	}

	public Carrello findByID(int id) {
		return (Carrello) getHibernateTemplate().get(Carrello.class,id);
	}

	@SuppressWarnings("unchecked")
	public List<Carrello> findAll() {
		return getHibernateTemplate().find("from Carrello");
	}

	public int count() {
		return findAll().size();
	}

}
