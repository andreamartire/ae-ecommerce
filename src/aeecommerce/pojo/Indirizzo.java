package aeecommerce.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Indirizzo {	

	@Id 
	@GeneratedValue
	int id;
	
	String via;
	
	String numero;
	
	String citta;
	
	String provincia;
	
	String cap;
	
	public Indirizzo(){}

	public Indirizzo(String via, String numero, String citta, String provincia, String cap) {
		this.via = via;
		this.numero = numero;
		this.citta = citta;
		this.provincia = provincia;
		this.cap = cap;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}
}
