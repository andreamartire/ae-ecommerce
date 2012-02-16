package aeecommerce.pojo;

import java.io.BufferedReader;
import java.sql.Clob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.Hibernate;

@Entity
public class Document {

	@Id
	@GeneratedValue
	private int id;

	private Clob faq;

	private Clob condizioni;
	
	private Clob doveSiamo;
	
	private Clob contattaci;
	
	public Document() {
		this.faq = Hibernate.createClob("FAQ non specificate");
		this.condizioni = Hibernate.createClob("Condizioni non specificate");
		this.doveSiamo = Hibernate.createClob("DoveSiamo non specificato");
		this.contattaci = Hibernate.createClob("Contatti non specificati");
	}

	public Document(int id, Clob faq, Clob conditions, Clob doveSiamo, Clob contattaci) {
		this.id = id;
		this.faq = faq;
		this.condizioni = conditions;
		this.doveSiamo = doveSiamo;
		this.contattaci = contattaci;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Clob getFaq() {
		return faq;
	}

	public void setFaq(Clob faq) {
		this.faq = faq;
	}

	public Clob getConditions() {
		return condizioni;
	}

	public void setConditions(Clob conditions) {
		this.condizioni = conditions;
	}

	public Clob getDoveSiamo() {
		return doveSiamo;
	}

	public void setDoveSiamo(Clob doveSiamo) {
		this.doveSiamo = doveSiamo;
	}

	public Clob getContattaci() {
		return contattaci;
	}

	public void setContattaci(Clob contattaci) {
		this.contattaci = contattaci;
	}

	@Override
	public String toString(){
		return id + " " + faq + " " + condizioni + " " + doveSiamo + " " + contattaci;
	}

	public String ClobToString(Clob clob){
		StringBuffer str = new StringBuffer();
		String out;
		
		try {
			BufferedReader bufferRead = new BufferedReader(clob.getCharacterStream());
			while ((out=bufferRead.readLine())!=null)
				str.append(out);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return str.toString();
	}

	public DocumentForm toDocumentForm(){
		return new DocumentForm(id, ClobToString(faq), ClobToString(condizioni),
				ClobToString(doveSiamo), ClobToString(contattaci));
	}
}
