package eaecommerce.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class TipoSpedizione {

	@Id
	@GeneratedValue
	int id;
	
	/** Nome del tipo di spedizione
	 * e.g. Corriere espresso
	 */
	String nome;

	/** Descrizione testuale del tipo di spedizione
	 * e.g. Spedizione nazionale tramite corriere espresso SDA
	 * 		Tempi di spedizione previsti: 24/48 ore
	 * 		Escluso isole e zone disagiate
	 */
	String descrizione;
	
	/** Prezzo di partenza del tipo di spedizione
	 * e.g. 5,90 euro
	 * TODO: ci sara' qualche tipo per gli euro?
	 */
	double prezzoBase;
	
	/**
	 * Tutti gli ordini pagati con questa modalit� di pagamento
	 */
	@OneToMany(mappedBy = "tipoSpedizione")
	List<Ordine> ordini;
	
	public TipoSpedizione() {
		this.ordini = new ArrayList<Ordine>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public double getPrezzoBase() {
		return prezzoBase;
	}

	public void setPrezzoBase(double prezzoBase) {
		this.prezzoBase = prezzoBase;
	}
	
	public List<Ordine> getOrdini() {
		return ordini;
	}

	public void setOrdini(List<Ordine> ordini) {
		this.ordini = ordini;
	}

	@Override
	public String toString() {
		return nome + "\n" + descrizione + "\n" + prezzoBase + "\n";
	}
}
