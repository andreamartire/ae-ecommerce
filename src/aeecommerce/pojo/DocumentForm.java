package aeecommerce.pojo;

import java.sql.Blob;
import java.sql.Clob;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.Hibernate;

@Entity
public class DocumentForm {
 
    @Id
    @GeneratedValue
    private int id;
 
    private String faq;
    
    private String conditions;

	public DocumentForm(int id, String faq, String conditions) {
		this.id = id;
		this.faq = faq;
		this.conditions = conditions;
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

	@Override
	public String toString(){
		return id + " " + faq + " " + conditions;
	}
	
	public Document toDocument(){
		Document d = new Document(id,
								Hibernate.createClob(faq),
								Hibernate.createClob(conditions));
		return d;
	}
}
