package fatec.edu.walison.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Entity
public class Store extends UserApp implements Serializable {

	private static final long serialVersionUID = 1L;

	private String cnpj;
	private String address;
	private String category;
	@OneToMany(mappedBy = "store")
	private Set<Product> products = new HashSet<>();
	@OneToMany(mappedBy = "store")
	private Set<Employee> employees = new HashSet<>();

	public Store(String cnpj, String address, String category) {
		this.cnpj = cnpj;
		this.address = address;
		this.category = category;
	}

	public Store() {}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}


	public Set<Product> getProducts() {
		return products;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}
}
