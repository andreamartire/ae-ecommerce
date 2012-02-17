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
		this.doveSiamo = Hibernate.createClob("<p style=\"display:inline-block; vertical-align:middle; margin:0px auto; text-align:center;\"><iframe width=\"425\" height=\"350\" frameborder=\"0\" scrolling=\"no\" marginheight=\"0\" marginwidth=\"0\" src=\"http://maps.google.it/maps?f=q&amp;source=s_q&amp;hl=it&amp;geocode=&amp;q=Universit%C3%A0+della+Calabria,+Via+Pietro+Bucci,+Rende&amp;aq=0&amp;oq=universit%C3%A0+della&amp;sll=41.442726,12.392578&amp;sspn=16.852427,39.506836&amp;ie=UTF8&amp;hq=Universit%C3%A0+della+Calabria,+Via+Pietro+Bucci,+Rende&amp;t=h&amp;ll=39.355604,16.226978&amp;spn=0.023228,0.036478&amp;z=14&amp;iwloc=A&amp;output=embed\"></iframe><br /><small><a href=\"http://maps.google.it/maps?f=q&amp;source=embed&amp;hl=it&amp;geocode=&amp;q=Universit%C3%A0+della+Calabria,+Via+Pietro+Bucci,+Rende&amp;aq=0&amp;oq=universit%C3%A0+della&amp;sll=41.442726,12.392578&amp;sspn=16.852427,39.506836&amp;ie=UTF8&amp;hq=Universit%C3%A0+della+Calabria,+Via+Pietro+Bucci,+Rende&amp;t=h&amp;ll=39.355604,16.226978&amp;spn=0.023228,0.036478&amp;z=14&amp;iwloc=A\" style=\"color:#0000FF;text-align:left\">Visualizzazione ingrandita della mappa</a></small></p>");
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
