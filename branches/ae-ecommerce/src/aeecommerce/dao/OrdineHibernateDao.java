package aeecommerce.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import aeecommerce.pojo.Ordine;

@Component
public class OrdineHibernateDao extends HibernateDaoSupport implements OrdineDao {

	@Autowired
	public void init(SessionFactory factory) {
	    setSessionFactory(factory);
	}
	
	public void insert(Ordine p) {
		getHibernateTemplate().saveOrUpdate(p);
	}

	public void update(Ordine p) {
		getHibernateTemplate().saveOrUpdate(p);
	}

	public void delete(int id) {
		Ordine o = getHibernateTemplate().get(Ordine.class, id);
		getHibernateTemplate().delete(o);
	}

	public Ordine findByID(int id) {
		return getHibernateTemplate().get(Ordine.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Ordine> findAll() {
		return getHibernateTemplate().find("from Ordine");
	}

	public int count() {
		return findAll().size();
	}

	public void delete(Ordine o) {
		getHibernateTemplate().delete(o);
	}

}
