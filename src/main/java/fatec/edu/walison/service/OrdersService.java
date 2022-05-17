package fatec.edu.walison.service;

import fatec.edu.walison.model.Orders;
import fatec.edu.walison.repository.IOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class OrdersService {

    @Autowired
    IOrder repository;

    public List<Orders> findAll() {
        return repository.findAll();
    }

    public Orders findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException("Order not found"));
    }

    public Orders saveOrders(Orders Orders) {
        return repository.save(Orders);
    }

    public void deleteOrders(Long id) {
        Orders Orders = this.findById(id);
        repository.deleteById(Orders.getOrderId());
    }

}
