package fatec.edu.walison.controller;

import fatec.edu.walison.model.Client;
import fatec.edu.walison.model.Orders;
import fatec.edu.walison.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    OrdersService service;

    @GetMapping
    public ResponseEntity<List<Orders>> findAll() {
        List<Orders> orders = service.findAll();
        return ResponseEntity.ok().body(orders);
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<Orders> findOrders(@PathVariable Long id) {
        Orders orders = service.findById(id);
        return ResponseEntity.ok().body(orders);
    }

    @PutMapping("/order/{id}")
    public ResponseEntity<Orders> updateOrders(@PathVariable Long id, @RequestBody Orders orders) {
        Orders newOrders = service.findById(id);
        service.saveOrders(newOrders);
        return ResponseEntity.accepted().body(newOrders);
    }

    @PostMapping("/order/create")
    public ResponseEntity<Orders> createOrders(@RequestBody Orders orders) {
        orders = service.saveOrders(orders);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(orders.getOrderId()).toUri();
        return ResponseEntity.created(uri).body(orders);
    }

    @DeleteMapping("/order/delete/{id}")
    public ResponseEntity<Void> deleteOrders(@PathVariable Long id) {
        Orders orders = service.findById(id);
        if(orders != null) {
            service.deleteOrders(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().build();
    }

}
