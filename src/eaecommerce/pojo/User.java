package eaecommerce.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)
@Table(name="user")
public class User {

	@Id 
	@GeneratedValue
	@Column(name="id")
	int id;

	@Column(name="username")
	String username;

	@Column(name="password")
	String password;

	@Column(name="data_registrazione")
	Date dataRegistrazione;

	@OneToMany(cascade=CascadeType.ALL, mappedBy = "user")
	Set<Recapito> recapiti = new HashSet<Recapito>();

	@OneToMany(cascade=CascadeType.ALL, mappedBy = "user")
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
		ind.setUser(this);
		getIndirizzi().add(ind);
	}

	public void addRecapito(Recapito rec) {
		rec.setUser(this);
		getRecapiti().add(rec);
	}

	public String toString(){
		return id + " " + username + " " + password; 
	}
}
