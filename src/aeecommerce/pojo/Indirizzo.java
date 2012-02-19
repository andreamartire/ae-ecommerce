package aeecommerce.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Indirizzo {	

	@Id 
	@GeneratedValue
	int id;
	
	/** nome e cognome di chi potra' accettare il pacco */
	String destinatario;
	
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

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
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
	
	@Override
	public String toString(){
		return via + "," + numero + "," + citta + "," + provincia + "," + cap;
	}
}
