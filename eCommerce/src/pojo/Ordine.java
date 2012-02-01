package pojo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Ordine {

	@Id
	@GeneratedValue
	int id;
	
	/** Data in cui è stato effettuato l'ordine
	 */
	Date data;
	
	/**
	 * Peso totale (approssimato) dell'ordine
	 * Necessario per calcolare le spese di spedizione (NON IMPLEMENTATO)
	 */
	int pesoTotaleApprossimato;
	
	/**
	 * Totale in euro dell'ordine, dato da:
	 * totale prodotti + prezzo spedizione + commissioni pagamento
	 */
	double totaleDaPagare;
	
	/** 
	 * modalita' di pagamento scelta
	 */
	@ManyToOne(targetEntity = pojo.ModalitaPagamento.class, cascade=CascadeType.ALL)
	@JoinColumn(name = "modalita_pagamento_id", nullable = false)
	ModalitaPagamento modalitaPagamento;
	
	/**
	 * tipo di spedizione scelta
	 */
	@ManyToOne(targetEntity = pojo.TipoSpedizione.class, cascade=CascadeType.ALL)
	@JoinColumn(name = "tipo_spedizione_id", nullable = false)
	TipoSpedizione tipoSpedizione;
	
	public Ordine() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getPesoTotaleApprossimato() {
		return pesoTotaleApprossimato;
	}

	public void setPesoTotaleApprossimato(int pesoTotaleApprossimato) {
		this.pesoTotaleApprossimato = pesoTotaleApprossimato;
	}

	public double getTotaleDaPagare() {
		return totaleDaPagare;
	}

	public void setTotaleDaPagare(double totaleDaPagare) {
		this.totaleDaPagare = totaleDaPagare;
	}

	public ModalitaPagamento getModalitaPagamento() {
		return modalitaPagamento;
	}

	public void setModalitaPagamento(ModalitaPagamento modalitaPagamento) {
		this.modalitaPagamento = modalitaPagamento;
	}

	public TipoSpedizione getTipoSpedizione() {
		return tipoSpedizione;
	}

	public void setTipoSpedizione(TipoSpedizione tipoSpedizione) {
		this.tipoSpedizione = tipoSpedizione;
	}
	
	@Override
	public String toString() {
		return "Ordine: " + id + "\nData: " + data + "\nPeso: " + pesoTotaleApprossimato +
				"\nModalita' Pagamento: " + modalitaPagamento.getNome() + 
				"\nTipo spedizione: " + tipoSpedizione.getNome();
	}
}
