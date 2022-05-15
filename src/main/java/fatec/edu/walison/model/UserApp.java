package fatec.edu.walison.model;

import javax.annotation.Nullable;
import javax.persistence.*;

@MappedSuperclass
public abstract class UserApp {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	private String userName;
	@Nullable
	private String role;

	private String password;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserApp [userId=" + userId + ", userName=" + userName + ", role=" + role + ", password=" + password
				+ "]";
	}
	
	
	

}
