package aeecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aeecommerce.dao.RecapitoDao;
import aeecommerce.pojo.Recapito;

@Service
public class RecapitoServiceImpl implements RecapitoService {
	
	@Autowired
	private RecapitoDao recapitoDao;
	
	@Override
	public void delete(int id) {
		recapitoDao.delete(id);
		System.out.println("Recapito deleted");
	}

	@Override
	public void update(Recapito Recapito) {
		recapitoDao.update(Recapito);
		System.out.println("Recapito updated");
	}

	@Override
	public Recapito findById(int id) {
		return recapitoDao.findById(id);
	}

	@Override
	public List<Recapito> findAll() {
		return recapitoDao.findAll();
	}

	@Override
	public void insert(Recapito i) {
		recapitoDao.insert(i);
	}

}
