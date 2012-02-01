package pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Admin")
public class Amministratore extends User {
	
	@Column
	String banner;
	
	@Column
	String googleMap;

	public Amministratore() {
		// TODO Auto-generated constructor stub
	}

	public Amministratore(String username, String password,
			Date dataRegistrazione) {
		super(username, password, dataRegistrazione);
		// TODO Auto-generated constructor stub
	}

	public String getBanner() {
		return banner;
	}

	public void setBanner(String banner) {
		this.banner = banner;
	}

	public String getGoogleMap() {
		return googleMap;
	}

	public void setGoogleMap(String googleMap) {
		this.googleMap = googleMap;
	}

}
