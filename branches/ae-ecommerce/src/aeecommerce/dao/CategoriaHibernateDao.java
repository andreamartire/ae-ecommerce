package aeecommerce.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import aeecommerce.pojo.Categoria;

public class CategoriaHibernateDao extends HibernateDaoSupport implements CategoriaDao {
	public void insert(Categoria entity) {
		getHibernateTemplate().saveOrUpdate(entity);
	}

	public void update(Categoria entity) {
		getHibernateTemplate().save(entity);
	}

	public void delete(Categoria entity) {
		getHibernateTemplate().delete(entity);
	}

	public void delete(int id) {
		Categoria entity = (Categoria) getHibernateTemplate().get(Categoria.class, id);
		getHibernateTemplate().delete(entity);
	}

	public Categoria findByID(int id) {
		return (Categoria) getHibernateTemplate().get(Categoria.class,id);
	}

	@SuppressWarnings("unchecked")
	public List<Categoria> findAll() {
		return getHibernateTemplate().find("from Categoria");
	}

	public int count() {
		return findAll().size();
	}
}
