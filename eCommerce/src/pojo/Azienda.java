package pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="azienda")
public class Azienda extends Cliente {
	
	@Column
	String piva;
	
	@Column
	String ragioneSociale;

	public Azienda() {}

	public Azienda(String username, String password, Date dataRegistrazione) {
		super(username, password, dataRegistrazione);
	}

	public String getPiva() {
		return piva;
	}

	public void setPiva(String piva) {
		this.piva = piva;
	}

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}
}
