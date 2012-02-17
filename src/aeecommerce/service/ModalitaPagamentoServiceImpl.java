package aeecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aeecommerce.dao.ModalitaPagamentoDao;
import aeecommerce.pojo.ModalitaPagamento;

@Service
public class ModalitaPagamentoServiceImpl implements ModalitaPagamentoService {

	@Autowired
	ModalitaPagamentoDao modalitaPagamentoDao;
	
	@Override
	public List<ModalitaPagamento> list() {
		return modalitaPagamentoDao.findAll();
	}

	@Override
	public void insert(ModalitaPagamento c) {
		modalitaPagamentoDao.insert(c);
	}

	@Override
	public void delete(ModalitaPagamento c) {
		modalitaPagamentoDao.delete(c);
	}

	@Override
	public void update(ModalitaPagamento c) {
		modalitaPagamentoDao.update(c);
	}

	@Override
	public void delete(int id) {
		modalitaPagamentoDao.delete(id);
	}

	@Override
	public ModalitaPagamento findById(int id) {
		return modalitaPagamentoDao.findByID(id);
	}
}
