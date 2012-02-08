package aeecommerce.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	
	@OneToMany(mappedBy="carrello")
	List<ElementoCarrello> elementiCarrello;
	
	/**
	 * Non � necessario che ad ogni carrello sia associato un ordine, mentre
	 * lo � il viceversa (ad un ordine deve essere associato un carrello..)
	 */
	@OneToOne(mappedBy="carrello", optional=true)
	Ordine ordine;
	
	@ManyToOne
	Cliente cliente;
	
	public Carrello() {
		this.elementiCarrello = new ArrayList<ElementoCarrello>();
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
			System.err.println("add elemento carrello");
		}
	}
	
	public void removeElementoCarrello(ElementoCarrello ec) {
		try {
			this.elementiCarrello.remove(ec);
		} catch (Exception e) {
			System.err.println("remove elemento carrello");
		}
	}
}
