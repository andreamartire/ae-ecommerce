package pojo;

import java.util.Date;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Cliente extends User {

	public Cliente() {}

	public Cliente(String username, String password, Date dataRegistrazione) {
		super(username, password, dataRegistrazione);
	}

}
