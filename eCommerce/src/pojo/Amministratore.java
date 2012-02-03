package pojo;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Amministratore extends User {
	
	String banner;
	
	String googleMap;

	public Amministratore() {
	}

	public Amministratore(String username, String password,
			Date dataRegistrazione) {
		super(username, password, dataRegistrazione);
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
