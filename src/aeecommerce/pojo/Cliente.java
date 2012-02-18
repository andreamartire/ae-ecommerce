package aeecommerce.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Cliente extends User implements Serializable{

	@OneToMany(mappedBy="cliente", fetch = FetchType.EAGER)
	List<Carrello> carrelli;
	
	public Cliente() {}

	public Cliente(String username, String password, Date dataRegistrazione) {
		super(username, password, dataRegistrazione);
		carrelli = new ArrayList<Carrello>();
	}
	
	@Override
	public String toString() {
		return username;
	}

	public List<Carrello> getCarrelli() {
		return carrelli;
	}

	public void setCarrelli(List<Carrello> carrelli) {
		this.carrelli = carrelli;
	}
	
	public void addCarrello(Carrello c) {
		this.carrelli.add(c);
	}
	
	public void removeCarrello(Carrello c) {
		this.carrelli.remove(c);
	}
}
