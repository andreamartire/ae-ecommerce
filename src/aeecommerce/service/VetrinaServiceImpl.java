package aeecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aeecommerce.dao.VetrinaDao;
import aeecommerce.pojo.Vetrina;

@Service
public class VetrinaServiceImpl implements VetrinaService {
	
	@Autowired
	private VetrinaDao vetrinaDao;

	@Override
	public void update(Vetrina d) {
		vetrinaDao.update(d);
	}

	@Override
	public Vetrina load() {
		return vetrinaDao.load();
	}

	@Override
	public void save(Vetrina Vetrina) {
		vetrinaDao.insert(Vetrina);
	}

	@Override
	public void delete(Vetrina vetrina) {
		vetrinaDao.delete(vetrina);
	}

	@Override
	public void deleteProdotto(int idProdotto) {
		vetrinaDao.deleteProdotto(idProdotto);
	}
}
