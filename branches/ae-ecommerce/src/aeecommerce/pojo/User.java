package aeecommerce.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.context.annotation.Lazy;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

	@Id 
	@GeneratedValue
	int id;

	String username;

	String password;

	@Temporal(TemporalType.DATE)
	Date dataRegistrazione;

	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	Set<Recapito> recapiti = new HashSet<Recapito>();

	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	Set<Indirizzo> indirizzi = new HashSet<Indirizzo>();

	public User() {}

	public User(String username, String password, Date dataRegistrazione) {
		this.username = username;
		this.password = password;
		this.dataRegistrazione = dataRegistrazione;
	}

	public User(int id) {
		setId(id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDataRegistrazione() {
		return dataRegistrazione;
	}

	public void setDataRegistrazione(Date dataRegistrazione) {
		this.dataRegistrazione = dataRegistrazione;
	}

	public Set<Recapito> getRecapiti() {
		return recapiti;
	}

	public void setRecapiti(Set<Recapito> recapiti) {
		this.recapiti = recapiti;
	}

	public Set<Indirizzo> getIndirizzi() {
		return indirizzi;
	}

	public void setIndirizzi(Set<Indirizzo> indirizzi) {
		this.indirizzi = indirizzi;
	}

	public void addIndirizzo(Indirizzo ind) {
		getIndirizzi().add(ind);
	}

	public void addRecapito(Recapito rec) {
		getRecapiti().add(rec);
	}

	public String toString(){
		return id + " " + username + " " + password; 
	}
}
