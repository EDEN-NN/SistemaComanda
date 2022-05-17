package fatec.edu.walison.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
public class Client extends UserApp implements Serializable{

	private static final long serialVersionUID = 1L;

	private String email;

	private String birthDate;

	private String cpf;
	@OneToOne
	private Orders orders;

	public Client(String userName, String password, String email, String birthDate, String cpf) {
		this.setUserName(userName);
		this.setPassword(password);
		this.email = email;
		this.birthDate = birthDate;
		this.cpf = cpf;
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

	public Orders getOrder() {
		return orders;
	}

	public void setOrder(Orders orders) {
		this.orders = orders;
	}
}
