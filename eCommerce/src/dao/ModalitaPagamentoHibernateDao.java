package dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pojo.ModalitaPagamento;


public class ModalitaPagamentoHibernateDao extends HibernateDaoSupport implements ModalitaPagamentoDao {

	@Override
	public void insert(ModalitaPagamento p) {
		getHibernateTemplate().saveOrUpdate(p);
	}

	@Override
	public void update(ModalitaPagamento p) {
		getHibernateTemplate().saveOrUpdate(p);
	}

	@Override
	public void delete(int id) {
		ModalitaPagamento o = getHibernateTemplate().get(ModalitaPagamento.class, id);
		getHibernateTemplate().delete(o);
	}

	@Override
	public ModalitaPagamento findByID(int id) {
		return getHibernateTemplate().get(ModalitaPagamento.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ModalitaPagamento> findAll() {
		return getHibernateTemplate().find("from ModalitaPagamento");
	}

	@Override
	public int count() {
		return findAll().size();
	}

}
