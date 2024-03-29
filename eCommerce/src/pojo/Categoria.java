package pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Categoria {

	@Id
	@GeneratedValue
	int id;
	
	String nome;
	
	String descrizione;

	@ManyToOne(cascade=CascadeType.ALL)
	Categoria parent;
	
	@OneToMany(mappedBy="parent")
	List<Categoria> children;
	
	@OneToMany(mappedBy="categoria")
	List<Prodotto> prodotti;
	
	public Categoria() {
		this.prodotti = new ArrayList<Prodotto>();
		this.children = new ArrayList<Categoria>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Categoria getParent() {
		return parent;
	}

	public void setParent(Categoria parent) {
		this.parent = parent;
	}

	public List<Categoria> getChildren() {
		return children;
	}

	public void setChildren(List<Categoria> children) {
		this.children = children;
	}
	
	public List<Prodotto> getProdotti() {
		return prodotti;
	}

	public void setProdotti(List<Prodotto> prodotti) {
		this.prodotti = prodotti;
	}

	public void addSubCat(Categoria subCat) {
		this.children.add(subCat);
	}
	
	public void removeSubCat(Categoria subCat) {
		this.children.remove(subCat);
	}
	
	public void addProdotto(Prodotto prodotto) {
		this.prodotti.add(prodotto);
	}
	
	public void removeProdotto(Prodotto prodotto) {
		this.prodotti.remove(prodotto);
	}
}
