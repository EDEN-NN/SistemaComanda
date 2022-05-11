package fatec.edu.walison.security;

import static fatec.edu.walison.security.ApplicationUserPermission.ADMIN_WRITE;
import static fatec.edu.walison.security.ApplicationUserPermission.CLIENT_READ;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.google.common.collect.Sets;

public enum ApplicationUserRole {
	
	CLIENT(Sets.newHashSet()),
	ADMIN(Sets.newHashSet(CLIENT_READ, ADMIN_WRITE));
	
	private final Set<ApplicationUserPermission> permissions;
	
	ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
		this.permissions = permissions;
	}
	
	public Set<ApplicationUserPermission> getPermission() {
		return this.permissions;
	}
	
	public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermission().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));

        return permissions;
    }

}
