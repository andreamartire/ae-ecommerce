package pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Azienda extends Cliente {
	
	@Column
	String piva;
	
	@Column
	String ragioneSociale;

	public Azienda() {
		// TODO Auto-generated constructor stub
	}

	public Azienda(String username, String password, Date dataRegistrazione) {
		super(username, password, dataRegistrazione);
		// TODO Auto-generated constructor stub
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
