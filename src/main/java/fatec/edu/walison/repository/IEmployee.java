package fatec.edu.walison.repository;

import fatec.edu.walison.model.Client;
import fatec.edu.walison.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployee extends JpaRepository<Employee, Long> {

    Employee findByUsername(String username) throws UsernameNotFoundException;

}
