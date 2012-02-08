package aeecommerce.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

@Component
public class MasterDao extends HibernateDaoSupport  {

	@Autowired
	public void init(SessionFactory factory) {
	    setSessionFactory(factory);
	}
}
