package fatec.edu.walison.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
public class Client extends UserApp implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name = "birthdate")
	private String birthDate;

	@Column(nullable = false, unique = true, name = "cpf")
	private String cpf;

	@OneToOne
	private Orders orders;

	public Client(String userName, String password, String email, String phone, String birthDate, String cpf) {
		this.setUserName(userName);
		this.setPassword(password);
		this.setEmail(email);
		this.setPhone(phone);
		this.birthDate = birthDate;
		this.cpf = cpf;
		this.getRole().add(Role.CLIENT);
	}

	public Client() {}

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

	public Orders getOrder() {
		return orders;
	}

	public void setOrder(Orders orders) {
		this.orders = orders;
	}
}
