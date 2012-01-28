package dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import pojo.Recapito;
import pojo.User;

public class RecapitoHibernateDao extends HibernateDaoSupport implements RecapitoDao {

	@Override
	public void update(Recapito r) {
		getHibernateTemplate().update(r);
	}

	@Override
	public void delete(Recapito r) {
		getHibernateTemplate().delete(r);
	}

	@Override
	public Recapito findById(int id) {
		return (Recapito) getHibernateTemplate().get(Recapito.class,id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Recapito> findAllRecapito() {
		return getHibernateTemplate().find("from Recapito");
	}

	@Override
	public int recapitoCount() {
		return findAllRecapito().size();
	}
}
