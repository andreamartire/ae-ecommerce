package aeecommerce.pojo;

import java.io.BufferedReader;
import java.sql.Clob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Document {

	@Id
	@GeneratedValue
	private int id;

	private Clob faq;

	private Clob conditions;

	public Document() {}

	public Document(int id, Clob faq, Clob conditions) {
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

	public Clob getFaq() {
		return faq;
	}

	public void setFaq(Clob faq) {
		this.faq = faq;
	}

	public Clob getConditions() {
		return conditions;
	}

	public void setConditions(Clob conditions) {
		this.conditions = conditions;
	}

	@Override
	public String toString(){
		return id + " " + faq + " " + conditions;
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
		return new DocumentForm(id, ClobToString(faq), ClobToString(conditions));
	}
}
