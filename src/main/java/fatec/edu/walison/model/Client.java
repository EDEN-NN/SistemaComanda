package fatec.edu.walison.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class Client extends UserApp implements Serializable{

	private static final long serialVersionUID = 1L;

	private String email;

	private String birthDate;

	private String cpf;
	@OneToOne
	private Order order;

	public Client(String email, String birthDate, String cpf, Order order) {
		this.email = email;
		this.birthDate = birthDate;
		this.cpf = cpf;
		this.order = order;
	}

	public Client() {}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
}
