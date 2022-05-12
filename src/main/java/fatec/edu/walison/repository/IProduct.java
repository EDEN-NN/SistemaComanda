package fatec.edu.walison.repository;

import fatec.edu.walison.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProduct extends JpaRepository<Product, Long> {
}
