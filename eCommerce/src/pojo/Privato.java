package pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Privato extends Cliente {

	String nome;
	
	String cognome;
	
	String codiceFiscale;
	
	@Temporal(TemporalType.DATE)
	Date dataNascita;
	
	String luogoNascita;
	
	public Privato() {}

	public Privato(String username, String password, Date dataRegistrazione) {
		super(username, password, dataRegistrazione);
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
		return super.toString() + "\n" + nome + " " + cognome + " " + codiceFiscale;
	}
}
