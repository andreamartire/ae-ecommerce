package aeecommerce.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import aeecommerce.pojo.Ordine;

@Component
public class OrdineHibernateDao extends MasterDao implements OrdineDao {
	
	@Transactional
	@Override
	public void insert(Ordine p) {
		getHibernateTemplate().saveOrUpdate(p);
	}

	@Transactional
	@Override
	public void update(Ordine p) {
		getHibernateTemplate().saveOrUpdate(p);
	}

	@Transactional
	@Override
	public void delete(int id) {
		Ordine o = getHibernateTemplate().get(Ordine.class, id);
		getHibernateTemplate().delete(o);
	}

	@Transactional
	@Override
	public Ordine findByID(int id) {
		return getHibernateTemplate().get(Ordine.class, id);
	}

	@Transactional
	@Override
	@SuppressWarnings("unchecked")
	public List<Ordine> findAll() {
		return getHibernateTemplate().find("from Ordine");
	}

	@Transactional
	@Override
	public int count() {
		return findAll().size();
	}

	@Transactional
	@Override
	public void delete(Ordine o) {
		getHibernateTemplate().delete(o);
	}

}
