package fatec.edu.walison.model;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Role implements Serializable {

    private static final String client = "CLIENT";
    private static final String employee = "EMPLOYEE";
    private static final String store = "STORE";


}
