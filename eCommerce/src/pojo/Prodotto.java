package pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Prodotto {

	@Id
	@GeneratedValue
	int id;
	
	String nome;
	
	String descrizione;
	
	int pesoApprossimato;
	
	double percentualeIVA;

	double prezzoUnitario;
	
	String immagine; //TODO string o Image?
	
	@ManyToOne
	Categoria categoria;
	
	public Prodotto() {
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

	public int getPesoApprossimato() {
		return pesoApprossimato;
	}

	public void setPesoApprossimato(int pesoApprossimato) {
		this.pesoApprossimato = pesoApprossimato;
	}

	public double getPercentualeIVA() {
		return percentualeIVA;
	}

	public void setPercentualeIVA(double percentualeIVA) {
		this.percentualeIVA = percentualeIVA;
	}

	public double getPrezzoUnitario() {
		return prezzoUnitario;
	}

	public void setPrezzoUnitario(double prezzoUnitario) {
		this.prezzoUnitario = prezzoUnitario;
	}

	public String getImmagine() {
		return immagine;
	}

	public void setImmagine(String immagine) {
		this.immagine = immagine;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
