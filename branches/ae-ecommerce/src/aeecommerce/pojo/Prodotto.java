package aeecommerce.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Prodotto {

	@Id
	@GeneratedValue
	int id;
	
	String nome;
	
	@Lob
	String descrizione;
	
	int pesoApprossimato;
	
	double percentualeIVA;

	double prezzoUnitario;
	
	String immagine; //non usato attualmente
	
	/** 
	 * Se un certo prodotto viene cancellato, vengono cancellate 
	 * tutte le offerte che lo riguardano
	 */
	@OneToMany(mappedBy="prodotto", cascade = CascadeType.ALL)
	List<Offerta> offerte;
	
	/** 
	 * Se un certo prodotto viene cancellato, vengono cancellati 
	 * tutti gli elementi di carrello che lo contenevano
	 */
	@OneToMany(mappedBy="prodotto", cascade = CascadeType.ALL)
	List<ElementoCarrello> elementiCarrello;
	
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
