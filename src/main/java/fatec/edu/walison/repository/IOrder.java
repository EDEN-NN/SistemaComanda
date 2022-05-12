package fatec.edu.walison.repository;

import fatec.edu.walison.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrder extends JpaRepository<Order, Long> {
}
