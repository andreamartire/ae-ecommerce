package aeecommerce.pojo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Ordine {

	@Id
	@GeneratedValue
	int id;
	
	/** Data in cui e' stato effettuato l'ordine
	 */
	@Temporal(TemporalType.DATE)
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
	@ManyToOne
	ModalitaPagamento modalitaPagamento;
	
	/**
	 * tipo di spedizione scelta
	 */
	@ManyToOne
	TipoSpedizione tipoSpedizione;
	
	/** 
	 * Carrello spesa dell'ordine
	 * Se un ordine viene cancellato vengono cancellati anche i carrelli ad esso associati...
	 */
	@OneToOne(cascade=CascadeType.ALL)
	Carrello carrello;
	
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
	
	public Carrello getCarrello() {
		return carrello;
	}

	public void setCarrello(Carrello carrello) {
		this.carrello = carrello;
	}

	@Override
	public String toString() {
		return "Ordine: " + id + "\nData: " + data + "\nPeso: " + pesoTotaleApprossimato +
				"\nModalita' Pagamento: " + modalitaPagamento.getNome() + 
				"\nTipo spedizione: " + tipoSpedizione.getNome();
	}
}
