package aeecommerce.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import aeecommerce.pojo.ModalitaPagamento;

@Component
public class ModalitaPagamentoHibernateDao extends HibernateDaoSupport implements ModalitaPagamentoDao {

	@Autowired
	public void init(SessionFactory factory) {
	    setSessionFactory(factory);
	}
	
	public void insert(ModalitaPagamento p) {
		getHibernateTemplate().saveOrUpdate(p);
	}

	public void update(ModalitaPagamento p) {
		getHibernateTemplate().saveOrUpdate(p);
	}

	public void delete(int id) {
		ModalitaPagamento o = getHibernateTemplate().get(ModalitaPagamento.class, id);
		getHibernateTemplate().delete(o);
	}

	public ModalitaPagamento findByID(int id) {
		return getHibernateTemplate().get(ModalitaPagamento.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<ModalitaPagamento> findAll() {
		return getHibernateTemplate().find("from ModalitaPagamento");
	}

	public int count() {
		return findAll().size();
	}

	public void delete(ModalitaPagamento p) {
		getHibernateTemplate().delete(p);
	}

}