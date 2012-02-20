package aeecommerce.dao;

import org.hibernate.SQLQuery;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import aeecommerce.pojo.Vetrina;

@Component
public class VetrinaHibernateDao extends MasterDao implements VetrinaDao {

	@Transactional
	@Override
	public void update(Vetrina d) {
		getHibernateTemplate().update(d);
	}

	@Override
	public Vetrina load() {
		if(getHibernateTemplate().find("from Vetrina") == null)
			System.out.println("Tabella vuota");
		if(getHibernateTemplate().find("from Vetrina").isEmpty())
			System.out.println("Lista vuota");
		if(getHibernateTemplate().find("from Vetrina") == null ||
				getHibernateTemplate().find("from Vetrina").isEmpty())
			return null;
		return (Vetrina) getHibernateTemplate().find("from Vetrina").get(0);
	}

	@Override
	public void insert(Vetrina Vetrina) {
		getHibernateTemplate().save(Vetrina);
	}

	@Override
	public void delete(Vetrina vetrina) {
		getHibernateTemplate().delete(vetrina);
	}

	@Override
	public void deleteProdotto(int idProdotto) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		SQLQuery q = session.createSQLQuery("delete from Vetrina_Prodotto where prodotti_id=" + idProdotto);
		q.executeUpdate();
		session.close();
	}
}
