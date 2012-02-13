package aeecommerce.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import aeecommerce.pojo.TipoSpedizione;

@Component
public class TipoSpedizioneHibernateDao extends MasterDao implements TipoSpedizioneDao {

	@Transactional
	@Override
	public void update(TipoSpedizione r) {
		getHibernateTemplate().update(r);
	}

	@Transactional
	@Override
	public void delete(int id) {
		TipoSpedizione indirizzo = (TipoSpedizione) getHibernateTemplate().get(TipoSpedizione.class, id);
		getHibernateTemplate().delete(indirizzo);
	}

	@Transactional
	@Override
	public TipoSpedizione findById(int id) {
		return (TipoSpedizione) getHibernateTemplate().get(TipoSpedizione.class, id);
	}

	@Transactional
	@Override
	@SuppressWarnings("unchecked")
	public List<TipoSpedizione> findAll() {
		return getHibernateTemplate().find("from TipoSpedizione");
	}

	@Transactional
	@Override
	public int count() {
		return findAll().size();
	}

	@Transactional
	@Override
	public void insert(TipoSpedizione m) {
		getHibernateTemplate().saveOrUpdate(m);
	}

	@Transactional
	@Override
	public void delete(TipoSpedizione entity) {
		getHibernateTemplate().delete(entity);
	}
}
