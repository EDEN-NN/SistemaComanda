package fatec.edu.walison.model;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Map;
import java.util.Set;

@Entity
public class Store extends UserApp implements Serializable {

	private static final long serialVersionUID = 1L;
	Set<Product> productSet;
	Set<Employee> employees;
	Set<Client> clients;
	Order orders;

	public Store(Set<Product> productSet, Set<Employee> employees, Set<Client> clients, Order orders) {
		this.productSet = productSet;
		this.employees = employees;
		this.clients = clients;
		this.orders = orders;
	}

	public Store() {}

	public Set<Product> getProductSet() {
		return productSet;
	}

	public void setProductSet(Set<Product> productSet) {
		this.productSet = productSet;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Set<Client> getClients() {
		return clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

	public Order getOrders() {
		return orders;
	}

	public void setOrders(Order orders) {
		this.orders = orders;
	}
}
