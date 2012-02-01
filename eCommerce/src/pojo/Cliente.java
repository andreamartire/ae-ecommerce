package pojo;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Cliente extends User {

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente(String username, String password, Date dataRegistrazione) {
		super(username, password, dataRegistrazione);
		// TODO Auto-generated constructor stub
	}

}
