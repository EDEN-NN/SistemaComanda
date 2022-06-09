package fatec.edu.walison.repository;

import fatec.edu.walison.model.Client;
import fatec.edu.walison.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public interface IStore extends JpaRepository<Store, Long> {
    Store findByUsername(String username) throws UsernameNotFoundException;
}
