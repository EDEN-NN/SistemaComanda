package fatec.edu.walison.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
public class Role implements GrantedAuthority {

    @Id
    @Column(name = "nameRole")
    private String nameRole;

    @ManyToMany
    private List<UserApp> user;

    public Role(String nameRole) {
        this.nameRole = nameRole;
    }

    public Role() {
    }

    @Override
    public String getAuthority() {
        return this.nameRole;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }
}
