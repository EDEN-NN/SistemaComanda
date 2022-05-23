package fatec.edu.walison.model;

import org.checkerframework.checker.units.qual.C;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	@OneToMany(mappedBy = "store")
	private Set<Product> products = new HashSet<>();
	@OneToMany(mappedBy = "store")
	private Set<Employee> employees = new HashSet<>();

	public Store(String userName, String password, String cnpj, String email, String phone, String address, String category) {
		this.setUserName(userName);
		this.setPassword(password);
		this.setEmail(email);
		this.setPhone(phone);
		this.cnpj = cnpj;
		this.address = address;
		this.category = category;
//		this.getRole().addAll(Arrays.asList(Role.CLIENT, Role.EMPLOYEE, Role.ADMIN));
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
