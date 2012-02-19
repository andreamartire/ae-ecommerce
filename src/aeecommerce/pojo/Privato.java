package aeecommerce.pojo;

import java.util.Date;

import javax.persistence.Entity;

import aeecommerce.utils.DateUtils;
import aeecommerce.validation.RegistrationInfo;

@Entity
public class Privato extends Cliente {

	String nome;
	
	String cognome;
	
	String codiceFiscale;
	
	Date dataNascita;
	
	String luogoNascita;
	
	public Privato() {}

	public Privato(String username, String password, Date dataRegistrazione) {
		super(username, password, dataRegistrazione);
	}
	
	public Privato(String username, String password, String cognome, String nome, String cf, String luogoNascita, Date dataNascita) {
		super(username, password, DateUtils.now());
		setLuogoNascita(luogoNascita);
		setDataNascita(dataNascita);
		setCognome(cognome);
		setNome(nome);
		setCodiceFiscale(cf);
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

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getLuogoNascita() {
		return luogoNascita;
	}

	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\n" + nome + " " + cognome + " " + codiceFiscale + " " + dataNascita + " " + luogoNascita;
	}
	
	public RegistrationInfo toRegInfo(){
		RegistrationInfo r = new RegistrationInfo();
		r.setId(id);
		r.setUsername(username);
		r.setPassword(password);
		r.setNome(nome);
		r.setCognome(cognome);
		r.setCodiceFiscale(codiceFiscale);
		r.setDataNascita(dataNascita);
		r.setLuogoNascita(luogoNascita);
		r.setType("Privato");
		return r;
	}
}
