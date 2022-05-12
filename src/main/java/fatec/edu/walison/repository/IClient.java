package fatec.edu.walison.repository;

import fatec.edu.walison.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClient extends JpaRepository<Client, Long> {
}
