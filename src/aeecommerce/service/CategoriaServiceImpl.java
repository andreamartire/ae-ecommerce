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

}
