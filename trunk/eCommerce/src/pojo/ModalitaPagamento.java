package pojo;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ModalitaPagamento {
	
	@Id
	@GeneratedValue
	int id;
	
	/** Nome della modalità di pagamento
	 * e.g. Carta di credito
	 */
	String nome;
	
	/** Descrizione testuale della modalità di pagamento
	 * e.g. La transazione di pagamento con carta di credito viene effettuata 
	 * 		sui server sicuri di Banca-Sella con il sistema di sicurezza di ultima 
	 * 		generazione Verified by Visa. 
	 * 		.....
	 */
	String descrizione;
	
	/** Commissione per questa modalità di pagamento, espressa come
	 * percentuale del totale
	 */
	double commissioni;
	
	/**
	 * Tutti gli ordini pagati con questa modalità di pagamento
	 */
	@OneToMany(mappedBy = "modalitaPagamento")
	Set<Ordine> ordini;
	
	public ModalitaPagamento() {
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

	public double getCommissioni() {
		return commissioni;
	}

	public void setCommissioni(double commissioni) {
		this.commissioni = commissioni;
	}

	public Set<Ordine> getOrdini() {
		return ordini;
	}

	public void setOrdini(Set<Ordine> ordini) {
		this.ordini = ordini;
	}
}
