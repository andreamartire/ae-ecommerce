package aeecommerce.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class Recapito {

	public static String TELEFONO_FISSO = "Telefono Fisso";
	public static String CELLULARE = "Cellulare";
	public static String FAX = "Fax";
	public static String EMAIL = "eMail";
	public static String SITO_WEB = "Sito Web";
	
	@Id 
	@GeneratedValue
	int id;
	
	String valore;
	
	String tipo;
	
	public Recapito(){}
	
	public Recapito(String valore, String tipo) {
		this.valore = valore;
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValore() {
		return valore;
	}

	public void setValore(String valore) {
		this.valore = valore;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
