package fatec.edu.walison.model;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.List;

@Entity
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long orderId;
	private Client client;
	private Employee employee;
	private Product product;
	private List<Product> productList;
	
	
	
	
}
