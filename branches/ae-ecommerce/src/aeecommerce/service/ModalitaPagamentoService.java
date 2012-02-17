package aeecommerce.service;

import java.util.List;

import aeecommerce.pojo.ModalitaPagamento;

public interface ModalitaPagamentoService {
	public void insert(ModalitaPagamento c);
	public void delete(ModalitaPagamento c);
	public void delete(int id);
	public void update(ModalitaPagamento c);
	public List<ModalitaPagamento> list();
	public ModalitaPagamento findById(int id);
}
