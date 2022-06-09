package fatec.edu.walison.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.checkerframework.checker.units.qual.C;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Store extends UserApp implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(nullable = false, unique = true, name = "cnpj")
	private String cnpj;
	@Column(nullable = false, name = "address")
	private String address;
	@Column(name = "category")
	private String category;
	@JsonIgnore
	@OneToMany(mappedBy = "store", cascade = CascadeType.MERGE)
	private Set<Product> products = new HashSet<>();
	@JsonIgnore
	@OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
	private Set<Employee> employees = new HashSet<>();

	public Store(String username, String password, String cnpj, String email, String phone, String address, String category) {
		this.setUsername(username);
		this.setPassword(password);
		this.setEmail(email);
		this.setPhone(phone);
		this.cnpj = cnpj;
		this.address = address;
		this.category = category;
		this.getRole().
				addAll(Arrays.asList(new Role(null, "CLIENT_ROLE"),
						new Role(null, "EMPLOYEE_ROLE"),
						new Role(null, "ADMIN_ROLE")));
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
