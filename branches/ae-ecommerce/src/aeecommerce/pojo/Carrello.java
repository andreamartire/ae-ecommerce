package aeecommerce.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Carrello {

	@Id
	@GeneratedValue
	int id;
	
	@Temporal(TemporalType.DATE)
	Date dataCreazione;
	
	@OneToMany(mappedBy="carrello", cascade = CascadeType.ALL)
	List<ElementoCarrello> elementiCarrello;
	
	/**
	 * Non e' necessario che ad ogni carrello sia associato un ordine, mentre
	 * lo e' il viceversa (ad un ordine deve essere associato un carrello)
	 */
	@OneToOne(mappedBy="carrello", optional=true, cascade = CascadeType.ALL)
	Ordine ordine;
	
	@ManyToOne
	Cliente cliente;
	
	public Carrello() {
		this.elementiCarrello = new ArrayList<ElementoCarrello>();
	}

	@Override
	public String toString() {
		if (cliente != null)
			return 	"Carrello " + id + " di " + cliente.getUsername() + " - " + dataCreazione;
		return "carrello " + id + " associato a nessuno";
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataCreazione() {
		return dataCreazione;
	}

	public void setDataCreazione(Date dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	public List<ElementoCarrello> getElementiCarrello() {
		return elementiCarrello;
	}

	public void setElementiCarrello(List<ElementoCarrello> elementiCarrello) {
		this.elementiCarrello = elementiCarrello;
	}

	public Ordine getOrdine() {
		return ordine;
	}

	public void setOrdine(Ordine ordine) {
		this.ordine = ordine;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void addElementoCarrello(ElementoCarrello ec) {
		try {
			this.elementiCarrello.add(ec);
		} catch (Exception e) {
			System.err.println("add elemento carrello errore");
		}
	}
	
	public void removeElementoCarrello(ElementoCarrello ec) {
		try {
			elementiCarrello.remove(ec);
		} catch (Exception e) {
			System.out.println("remove elemento carrello error");
		}
	}
	
	public void removeElementoCarrello(int elementoCarrello) {
		for (ElementoCarrello e : elementiCarrello) {
			if (e.getId() == elementoCarrello) {
				elementiCarrello.remove(e);
				break;
			}
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.id == ((Carrello) obj).id;
	}
}
