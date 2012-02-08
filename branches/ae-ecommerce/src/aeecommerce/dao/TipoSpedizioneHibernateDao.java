package aeecommerce.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aeecommerce.pojo.TipoSpedizione;

@Component
public class TipoSpedizioneHibernateDao extends MasterDao implements TipoSpedizioneDao {

	@Autowired
	public void init(SessionFactory factory) {
	    setSessionFactory(factory);
	}
	
	public void update(TipoSpedizione r) {
		getHibernateTemplate().update(r);
	}

	public void delete(int id) {
		TipoSpedizione indirizzo = (TipoSpedizione) getHibernateTemplate().get(TipoSpedizione.class, id);
		getHibernateTemplate().delete(indirizzo);
	}

	public TipoSpedizione findById(int id) {
		return (TipoSpedizione) getHibernateTemplate().get(TipoSpedizione.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<TipoSpedizione> findAll() {
		return getHibernateTemplate().find("from TipoSpedizione");
	}

	public int count() {
		return findAll().size();
	}

	public void insert(TipoSpedizione m) {
		getHibernateTemplate().saveOrUpdate(m);
	}

	public void delete(TipoSpedizione entity) {
		getHibernateTemplate().delete(entity);
	}
}
