package aeecommerce.pojo;

import java.sql.Blob;
import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Amministratore extends User {
	
	Blob banner;
	
	String googleMap;

	public Amministratore() {
	}

	public Amministratore(String username, String password,
			Date dataRegistrazione) {
		super(username, password, dataRegistrazione);
	}

	public Blob getBanner() {
		return banner;
	}

	public void setBanner(Blob banner) {
		this.banner = banner;
	}

	public String getGoogleMap() {
		return googleMap;
	}

	public void setGoogleMap(String googleMap) {
		this.googleMap = googleMap;
	}

}
