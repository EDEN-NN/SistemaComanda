package fatec.edu.walison.model;

import org.checkerframework.common.reflection.qual.GetMethod;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@MappedSuperclass
public abstract class UserApp implements UserDetails {



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true, name = "id")
	private Long userId;

	@Column(nullable = false, unique = true, name = "email")
	private String email;

	@Column(nullable = false, name = "phone")
	private String phone;

	@Column(nullable = false, unique = true, name = "username")
	private String userName;

	@Nonnull
	private Set<Role> role = new HashSet<>();

	@Column(nullable = false, name = "password")
	private String password;


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getUsername() {
		return this.userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

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
	public Set<Role> getRole() {
		return role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	@Override
	public String toString() {
		return "UserApp [userId=" + userId + ", userName=" + userName + ", role=" + role + ", password=" + password
				+ "]";
	}
	
	
	

}
