package fatec.edu.walison.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;

	@OneToOne
	private Client client;
  	@ManyToOne
	@JoinColumn(name = "employee.userId")
	private Employee employee;
	@ManyToOne
	private Product product;

	public Order(Long orderId, Client client, Employee employee, Product product) {
		this.orderId = orderId;
		this.client = client;
		this.employee = employee;
		this.product = product;
	}

	public Order() {}

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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
