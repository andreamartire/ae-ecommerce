package aeecommerce.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import aeecommerce.pojo.Documents;

@Component
public class DocumentsHibernateDao extends MasterDao implements DocumentsDao {

	@Transactional
	@Override
	public void update(Documents d) {
		getHibernateTemplate().update(d);
	}
}
