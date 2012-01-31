package eaecommerce.pojo;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Ciente")
public class Cliente extends User {

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente(String username, String password, Date dataRegistrazione) {
		super(username, password, dataRegistrazione);
		// TODO Auto-generated constructor stub
	}

}
