package fatec.edu.walison.model;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.List;

@Entity
public class Employee extends UserApp implements Serializable {

	private static final long serialVersionUID = 1L;
	List<Order> orders;
	List<Client> clients;
	Store store;

	
}
