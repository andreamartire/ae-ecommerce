package aeecommerce.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import aeecommerce.pojo.Categoria;

@Component
public class CategoriaHibernateDao extends MasterDao implements CategoriaDao {
	
	@Transactional
	@Override
	public void insert(Categoria entity) {
		getHibernateTemplate().saveOrUpdate(entity);
	}

	@Transactional
	@Override
	public void update(Categoria entity) {
		getHibernateTemplate().saveOrUpdate(entity);
	}

	@Transactional
	@Override
	public void delete(Categoria entity) {
		getHibernateTemplate().delete(entity);
	}

	@Transactional
	@Override
	public void delete(int id) {
		Categoria entity = (Categoria) getHibernateTemplate().get(Categoria.class, id);
		getHibernateTemplate().delete(entity);
	}

	@Transactional
	@Override
	public Categoria findByID(int id) {
		return (Categoria) getHibernateTemplate().get(Categoria.class,id);
	}

	@Transactional
	@Override
	@SuppressWarnings("unchecked")
	public List<Categoria> findAll() {
		return getHibernateTemplate().find("from Categoria");
	}

	@Transactional
	@Override
	public int count() {
		return findAll().size();
	}

	@Transactional
	@Override
	public Categoria findByName(String parentString) {
		return (Categoria) getHibernateTemplate().find("from Categoria where nome="+parentString).get(0);
	}
}
