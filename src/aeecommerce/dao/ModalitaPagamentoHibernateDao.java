package aeecommerce.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import aeecommerce.pojo.ModalitaPagamento;

@Component
public class ModalitaPagamentoHibernateDao extends MasterDao implements ModalitaPagamentoDao {
	
	@Transactional
	@Override
	public void insert(ModalitaPagamento p) {
		getHibernateTemplate().saveOrUpdate(p);
	}

	@Transactional
	@Override
	public void update(ModalitaPagamento p) {
		getHibernateTemplate().saveOrUpdate(p);
	}

	@Transactional
	@Override
	public void delete(int id) {
		ModalitaPagamento o = getHibernateTemplate().get(ModalitaPagamento.class, id);
		getHibernateTemplate().delete(o);
	}

	@Transactional
	@Override
	public ModalitaPagamento findByID(int id) {
		return getHibernateTemplate().get(ModalitaPagamento.class, id);
	}

	@Transactional
	@Override
	@SuppressWarnings("unchecked")
	public List<ModalitaPagamento> findAll() {
		return getHibernateTemplate().find("from ModalitaPagamento");
	}

	@Transactional
	@Override
	public int count() {
		return findAll().size();
	}

	@Transactional
	@Override
	public void delete(ModalitaPagamento p) {
		getHibernateTemplate().delete(p);
	}

}
