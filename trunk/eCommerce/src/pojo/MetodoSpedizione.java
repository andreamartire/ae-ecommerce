package pojo;

import javax.persistence.*;

@Entity
@Table(name="metodoSpedizione")
public class MetodoSpedizione {

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
	 * TODO: ci sar� qualche tipo per gli euro?
	 */
	String prezzoBase;
	
	public MetodoSpedizione() {
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

	public String getPrezzoBase() {
		return prezzoBase;
	}

	public void setPrezzoBase(String prezzoBase) {
		this.prezzoBase = prezzoBase;
	}
	
	@Override
	public String toString() {
		return nome + "\n" + descrizione + "\n" + prezzoBase + "\n";
	}
}
