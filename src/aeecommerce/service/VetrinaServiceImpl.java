package aeecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aeecommerce.dao.VetrinaDao;
import aeecommerce.pojo.Vetrina;

@Service
public class VetrinaServiceImpl implements VetrinaService {
	
	@Autowired
	private VetrinaDao VetrinasDao;

	@Override
	public void update(Vetrina d) {
		VetrinasDao.update(d);
	}

	@Override
	public Vetrina load() {
		return VetrinasDao.load();
	}

	@Override
	public void save(Vetrina Vetrina) {
		VetrinasDao.insert(Vetrina);
	}
}
