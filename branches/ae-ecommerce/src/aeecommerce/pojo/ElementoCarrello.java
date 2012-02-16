package aeecommerce.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ElementoCarrello {
	
	@Id
	@GeneratedValue
	int id;
	
	@ManyToOne
	Prodotto prodotto;
	
	int quantita;
	
	@ManyToOne
	Carrello carrello;
	
	public ElementoCarrello() {
	}

	@Override
	public String toString() {
		return quantita + "x '"+ prodotto.getNome() + "'";
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Prodotto getProdotto() {
		return prodotto;
	}

	public void setProdotto(Prodotto prodotto) {
		this.prodotto = prodotto;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public Carrello getCarrello() {
		return carrello;
	}

	public void setCarrello(Carrello carrello) {
		this.carrello = carrello;
	}
}
