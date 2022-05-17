package fatec.edu.walison.model;

import javax.annotation.Nullable;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Employee extends UserApp implements Serializable {

	private static final long serialVersionUID = 1L;

	private String cpf;
	private String hiredDate;
	@Nullable
	private String firedDate;
	@OneToMany(mappedBy = "employee")
	private final Set<Orders> orders = new HashSet<>();
	@ManyToOne
	@JoinColumn(name = "store_id")
	private Store store;

	public Employee(String cpf, String hiredDate, String firedDate, Store store) {
		this.cpf = cpf;
		this.hiredDate = hiredDate;
		this.firedDate = firedDate;
		this.store = store;
	}

	public Employee() {}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getHiredDate() {
		return hiredDate;
	}

	public void setHiredDate(String hiredDate) {
		this.hiredDate = hiredDate;
	}

	public String getFiredDate() {
		return firedDate;
	}

	public void setFiredDate(String firedDate) {
		this.firedDate = firedDate;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Set<Orders> getOrders() {
		return orders;
	}

}
