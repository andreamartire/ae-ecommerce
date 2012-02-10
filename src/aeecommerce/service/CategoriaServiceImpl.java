package aeecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aeecommerce.dao.CategoriaDao;
import aeecommerce.pojo.Categoria;

@Service
public class CategoriaServiceImpl implements CategoriaService {
	
	@Autowired
	CategoriaDao categoriaDao;
	
	@Override
	public List<Categoria> list() {
		return categoriaDao.findAll();
	}

	@Override
	public void insert(Categoria c) {
		categoriaDao.insert(c);
	}

	@Override
	public Categoria findByName(String parentString) {
		return categoriaDao.findByName(parentString);
	}

	@Override
	public void delete(Categoria c) {
		categoriaDao.delete(c);
	}

	@Override
	public void update(Categoria c) {
		categoriaDao.update(c);
	}

	@Override
	public void delete(int id) {
		categoriaDao.delete(id);
	}

	@Override
	public Categoria findById(int id) {
		return categoriaDao.findByID(id);
	}

}
