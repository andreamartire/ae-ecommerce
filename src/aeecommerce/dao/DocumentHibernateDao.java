package aeecommerce.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import aeecommerce.pojo.Document;

@Component
public class DocumentHibernateDao extends MasterDao implements DocumentDao {

	@Transactional
	@Override
	public void update(Document d) {
		getHibernateTemplate().update(d);
	}

	@Override
	public Document load() {
		if(getHibernateTemplate().find("from Document") == null)
			System.out.println("Tabella vuota");
		if(getHibernateTemplate().find("from Document").isEmpty())
			System.out.println("Lista vuota");
		if(getHibernateTemplate().find("from Document") == null ||
				getHibernateTemplate().find("from Document").isEmpty())
			return null;
		return (Document) getHibernateTemplate().find("from Document").get(0);
	}

	@Override
	public void insert(Document document) {
		getHibernateTemplate().save(document);
	}
}
