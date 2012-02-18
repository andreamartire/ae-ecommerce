package aeecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aeecommerce.dao.TipoSpedizioneDao;
import aeecommerce.pojo.TipoSpedizione;

@Service
public class SpedizioniServiceImpl implements SpedizioniService {
	
	@Autowired
	private TipoSpedizioneDao tipoSpedizioneDao;
	
	@Override
	public void delete(int id) {
		tipoSpedizioneDao.delete(id);
		System.out.println("TipoSpedizione deleted");
	}

	@Override
	public void update(TipoSpedizione TipoSpedizione) {
		tipoSpedizioneDao.update(TipoSpedizione);
		System.out.println("TipoSpedizione updated");
	}

	@Override
	public TipoSpedizione findById(int id) {
		return tipoSpedizioneDao.findById(id);
	}

	@Override
	public List<TipoSpedizione> findAll() {
		return tipoSpedizioneDao.findAll();
	}

	@Override
	public void insert(TipoSpedizione i) {
		tipoSpedizioneDao.insert(i);
	}

}
