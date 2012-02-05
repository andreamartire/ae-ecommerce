package aeecommerce.pojo;

import java.util.Date;

import javax.persistence.Entity;

import aeecommerce.utils.DateUtils;

@Entity
public class Azienda extends Cliente {
	
	String piva;
	
	String ragioneSociale;

	public Azienda() {}

	public Azienda(String username, String password, Date dataRegistrazione) {
		super(username, password, dataRegistrazione);
	}

	public Azienda(String username, String password, String piva,String ragioneSociale) {
		super(username, password, DateUtils.now());
		setPiva(piva);
		setRagioneSociale(ragioneSociale);
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
	
	@Override
	public String toString() {
		return id + " " + ragioneSociale + " " + piva;
	}
}
