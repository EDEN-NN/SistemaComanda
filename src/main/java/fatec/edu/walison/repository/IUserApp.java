package fatec.edu.walison.repository;

import fatec.edu.walison.model.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserApp extends JpaRepository<UserApp, Long> {
}
