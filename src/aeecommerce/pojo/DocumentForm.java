package aeecommerce.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.Hibernate;

@Entity
public class DocumentForm {
 
    @Id
    @GeneratedValue
    private int id;
 
    private String faq;
    
    private String conditions;
    
    private String doveSiamo;
    
    private String contattaci;

	public DocumentForm(int id, String faq, String conditions, String doveSiamo, String contattaci) {
		this.id = id;
		this.faq = faq;
		this.conditions = conditions;
		this.doveSiamo = doveSiamo;
		this.contattaci = contattaci;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFaq() {
		return faq;
	}

	public void setFaq(String faq) {
		this.faq = faq;
	}

	public String getConditions() {
		return conditions;
	}

	public void setConditions(String conditions) {
		this.conditions = conditions;
	}

	public String getDoveSiamo() {
		return doveSiamo;
	}

	public void setDoveSiamo(String doveSiamo) {
		this.doveSiamo = doveSiamo;
	}

	public String getContattaci() {
		return contattaci;
	}

	public void setContattaci(String contattaci) {
		this.contattaci = contattaci;
	}

	@Override
	public String toString(){
		return id + " " + faq + " " + conditions + " " + doveSiamo + " " + contattaci;
	}
	
	public Document toDocument(){
		Document d = new Document(id,
								Hibernate.createClob(faq),Hibernate.createClob(conditions),
								Hibernate.createClob(doveSiamo),Hibernate.createClob(contattaci));
		return d;
	}
}
