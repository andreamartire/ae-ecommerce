package eaecommerce.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="recapito")
public class Recapito {

	public static String TELEFONO_FISSO = "Telefono Fisso";
	public static String CELLULARE = "Cellulare";
	public static String FAX = "Fax";
	public static String EMAIL = "eMail";
	public static String SITO_WEB = "Sito Web";
	

	@Id @GeneratedValue
	@Column(name="id")
	int id;
	
	@Column(name="valore")
	String valore;
	
	@Column(name="tipo")
	String tipo;
	
	@ManyToOne( targetEntity = eaecommerce.pojo.User.class )
	@JoinColumn(name = "user_id", nullable = false)
	User user;
	
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
