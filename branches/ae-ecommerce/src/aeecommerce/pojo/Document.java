package aeecommerce.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Document {

	@Id
	@GeneratedValue
	private int id;

	@Lob
	private String faq;

	@Lob
	private String condizioni;
	
	@Lob
	private String doveSiamo;
	
	@Lob
	private String contattaci;
	
	@Lob
	private String home;
	
	public Document() {
		this.faq = "FAQ non specificate";
		this.condizioni = "Condizioni non specificate";
		this.doveSiamo = "<p style=\"display:inline-block; vertical-align:middle; margin:0px auto; text-align:center;\"><iframe width=\"425\" height=\"350\" frameborder=\"0\" scrolling=\"no\" marginheight=\"0\" marginwidth=\"0\" src=\"http://maps.google.it/maps?f=q&amp;source=s_q&amp;hl=it&amp;geocode=&amp;q=Universit%C3%A0+della+Calabria,+Via+Pietro+Bucci,+Rende&amp;aq=0&amp;oq=universit%C3%A0+della&amp;sll=41.442726,12.392578&amp;sspn=16.852427,39.506836&amp;ie=UTF8&amp;hq=Universit%C3%A0+della+Calabria,+Via+Pietro+Bucci,+Rende&amp;t=h&amp;ll=39.355604,16.226978&amp;spn=0.023228,0.036478&amp;z=14&amp;iwloc=A&amp;output=embed\"></iframe><br /><small><a href=\"http://maps.google.it/maps?f=q&amp;source=embed&amp;hl=it&amp;geocode=&amp;q=Universit%C3%A0+della+Calabria,+Via+Pietro+Bucci,+Rende&amp;aq=0&amp;oq=universit%C3%A0+della&amp;sll=41.442726,12.392578&amp;sspn=16.852427,39.506836&amp;ie=UTF8&amp;hq=Universit%C3%A0+della+Calabria,+Via+Pietro+Bucci,+Rende&amp;t=h&amp;ll=39.355604,16.226978&amp;spn=0.023228,0.036478&amp;z=14&amp;iwloc=A\" style=\"color:#0000FF;text-align:left\">Visualizzazione ingrandita della mappa</a></small></p>";
		this.contattaci = "Contatti non specificati";
		this.home = "Home page da personalizzare.";
	}

	public Document(int id, String home, String faq, String conditions, String doveSiamo, String contattaci) {
		this.id = id;
		this.faq = faq;
		this.condizioni = conditions;
		this.doveSiamo = doveSiamo;
		this.contattaci = contattaci;
	}

	public int getId() {
		return id;
	}

	public String getCondizioni() {
		return condizioni;
	}

	public void setCondizioni(String condizioni) {
		this.condizioni = condizioni;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
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
		return condizioni;
	}

	public void setConditions(String conditions) {
		this.condizioni = conditions;
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
		return id + " " + faq + " " + condizioni + " " + doveSiamo + " " + contattaci;
	}
}
