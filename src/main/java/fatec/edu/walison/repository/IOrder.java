package fatec.edu.walison.repository;

import fatec.edu.walison.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrder extends JpaRepository<Orders, Long> {
}
