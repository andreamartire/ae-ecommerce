package aeecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aeecommerce.dao.ProdottoDao;
import aeecommerce.pojo.Prodotto;

@Service
public class ProdottoServiceImpl implements ProdottoService {

	@Autowired
	ProdottoDao prodottoDao;
	
	@Override
	public List<Prodotto> list() {
		return prodottoDao.findAll();
	}

	@Override
	public void insert(Prodotto c) {
		prodottoDao.insert(c);
	}
//
//	@Override
//	public Prodotto findByName(String parentString) {
//		return prodottoDao.findByName(parentString);
//	}

	@Override
	public void delete(Prodotto c) {
		prodottoDao.delete(c);
	}

	@Override
	public void update(Prodotto c) {
		prodottoDao.update(c);
	}

	@Override
	public void delete(int id) {
		prodottoDao.delete(id);
	}

	@Override
	public Prodotto findById(int id) {
		return prodottoDao.findByID(id);
	}
}
