package aeecommerce.service;

import java.util.List;

import aeecommerce.pojo.Categoria;

public interface CategoriaService {

	public void insert(Categoria c);
	public void delete(Categoria c);
	public void delete(int id);
	public void update(Categoria c);
	public List<Categoria> list();
	public Categoria findByName(String parentString);
	public Categoria findById(int id);
}

