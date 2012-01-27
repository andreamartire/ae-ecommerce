package pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="recapito")
public class Recapito {

	public enum Tipo {
		TELEFONO_FISSO,
		CELLULARE,
		FAX,
		EMAIL,
		SITO_WEB
	}

	@Id @GeneratedValue
	@Column(name="recapito_id")
	int id;
	
	@Column(name="valore")
	String valore;
	
	@Column(name="tipo")
	Tipo tipo;
	
	public Recapito(){}
	
	public Recapito(String valore, Tipo tipo) {
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

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
}
