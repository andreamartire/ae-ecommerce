package aeecommerce.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Vetrina {
	
	@Id @GeneratedValue
	int id;
	
	@OneToMany(mappedBy="vetrina", fetch = FetchType.EAGER)
	List<Prodotto> prodotti;
	
	public Vetrina() {
		prodotti = new ArrayList<Prodotto>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Prodotto> getProdotti() {
		return prodotti;
	}

	public void setProdotti(List<Prodotto> prodotti) {
		this.prodotti = prodotti;
	}
}
