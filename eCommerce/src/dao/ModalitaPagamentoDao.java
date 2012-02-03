package dao;

import java.util.List;

import pojo.ModalitaPagamento;;

public interface ModalitaPagamentoDao {

	public void insert(ModalitaPagamento p);
	public void update(ModalitaPagamento p);
	public void delete(int id);
	public void delete(ModalitaPagamento p);
	public ModalitaPagamento findByID(int id); 
	public List<ModalitaPagamento> findAll();  
	public int count();
}
