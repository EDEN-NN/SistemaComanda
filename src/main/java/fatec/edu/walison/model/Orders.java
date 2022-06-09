package fatec.edu.walison.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Orders implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;

	@JsonIgnore
	@OneToOne
	private Client client;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;
	@JsonIgnore
	@OneToMany(mappedBy = "orders", fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private Set<Product> products = new HashSet<>();

	public Orders(Long orderId, Client client, Employee employee) {
		this.orderId = orderId;
		this.client = client;
		this.employee = employee;
	}

	public Orders() {}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Set<Product> getProducts() {
		return products;
	}

}
