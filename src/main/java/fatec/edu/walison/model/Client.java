package fatec.edu.walison.model;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Client extends UserApp implements Serializable{

	private static final long serialVersionUID = 1L;
	Order order;

	
	
	
}
