package fatec.edu.walison.model;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public enum Role implements Serializable {
    CLIENT,
    EMPLOYEE,
    ADMIN;
}
