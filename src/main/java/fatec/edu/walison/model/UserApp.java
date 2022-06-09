package fatec.edu.walison.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.checkerframework.common.reflection.qual.GetMethod;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.persistence.*;
import java.util.*;


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
	private String username;

//	@JsonIgnore
	@ManyToMany(cascade = CascadeType.MERGE)
	@Transient
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(
			name = "user_id", referencedColumnName = "userId"
	) )
	private List<Role> roles = new ArrayList<>();

	@Column(nullable = false, name = "password")
	private String password;


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		Collection<SimpleGrantedAuthority> collection = new ArrayList<>();
		roles.forEach(role -> collection.add(new SimpleGrantedAuthority(role.getNameRole())));

		return collection;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<Role> getRole() {
		return roles;
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
		return "UserApp [userId=" + userId + ", username=" + username + ", role=" + roles + ", password=" + password
				+ "]";
	}
	
	
	

}
