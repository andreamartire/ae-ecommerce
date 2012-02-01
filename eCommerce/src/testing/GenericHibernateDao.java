package testing;


import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/** A generic DAO implementation
 */
public abstract class GenericHibernateDao extends HibernateDaoSupport {
	public void insert(Object entity) {
		getHibernateTemplate().saveOrUpdate(entity);
	}

	public void update(Object entity) {
		getHibernateTemplate().saveOrUpdate(entity);
	}

	public void delete(Object entity) {
		getHibernateTemplate().delete(entity);
	}
	
	public void delete(int id) {
		Object entity = getHibernateTemplate().get(Object.class, id);
		getHibernateTemplate().delete(entity);
	}

	public Object findById(int id) {
		return getHibernateTemplate().get(Object.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Object> findAll(Class<?> entityClass) {
		return getHibernateTemplate().find("from " + entityClass.getName());
	}

	public int count(Class<?> entityClass) {
		return findAll(entityClass).size();
	}
}
