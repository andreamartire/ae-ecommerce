package aeecommerce.validation;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import aeecommerce.pojo.Azienda;
import aeecommerce.pojo.Privato;

public class RegistrationInfo {

	private String username;
	private String password;
	private String confirmPassword;

	String type;

	//Privato
	String nome;
	String cognome;
	String codiceFiscale;
	String dataNascita;
	String luogoNascita;
	
	//Azienda
	String piva;
	String ragioneSociale;
	
	public RegistrationInfo() {}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	public String getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}
	public String getLuogoNascita() {
		return luogoNascita;
	}
	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}
	public String getPiva() {
		return piva;
	}
	public void setPiva(String piva) {
		this.piva = piva;
	}
	public String getRagioneSociale() {
		return ragioneSociale;
	}
	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public Privato newPrivato() {
		return new Privato(username,password,cognome,nome,codiceFiscale,luogoNascita,dataNascita);
	}

	public Azienda newAzienda() {
		return new Azienda(username,password,piva,ragioneSociale);
	}
}
