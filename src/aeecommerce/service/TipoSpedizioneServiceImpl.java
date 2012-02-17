package aeecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aeecommerce.dao.TipoSpedizioneDao;
import aeecommerce.pojo.TipoSpedizione;

@Service
public class TipoSpedizioneServiceImpl implements TipoSpedizioneService {

	@Autowired
	TipoSpedizioneDao tipoSpedizioneDao;
	
	@Override
	public List<TipoSpedizione> list() {
		return tipoSpedizioneDao.findAll();
	}

	@Override
	public void insert(TipoSpedizione c) {
		tipoSpedizioneDao.insert(c);
	}

	@Override
	public void delete(TipoSpedizione c) {
		tipoSpedizioneDao.delete(c);
	}

	@Override
	public void update(TipoSpedizione c) {
		tipoSpedizioneDao.update(c);
	}

	@Override
	public void delete(int id) {
		tipoSpedizioneDao.delete(id);
	}

	@Override
	public TipoSpedizione findById(int id) {
		return tipoSpedizioneDao.findById(id);
	}
}
