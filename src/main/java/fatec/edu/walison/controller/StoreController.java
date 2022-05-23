package fatec.edu.walison.controller;

import fatec.edu.walison.model.Client;
import fatec.edu.walison.model.Store;
import fatec.edu.walison.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/stores")
public class StoreController {

    @Autowired
    StoreService service;

    @GetMapping
    public ResponseEntity<List<Store>> findAll() {
        List<Store> stores = service.findAll();
        return ResponseEntity.ok().body(stores);
    }

    @GetMapping("/store/{id}")
    public ResponseEntity<Store> findStore(@PathVariable Long id) {
        Store store = service.findById(id);
        return ResponseEntity.ok().body(store);
    }

    @PutMapping("/store/{id}")
    public ResponseEntity<Store> updateStore(@PathVariable Long id, @RequestBody Store store) {
        store = service.findById(id);
        service.saveStore(store);
        return ResponseEntity.accepted().body(store);
    }

    @PostMapping("/store/create")
    public ResponseEntity<Store> createStore(@RequestBody Store store) {
        store = service.saveStore(store);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(store.getUserId()).toUri();
        return ResponseEntity.created(uri).body(store);
    }

    @DeleteMapping("/store/delete/{id}")
    public ResponseEntity<Void> deleteStore(@PathVariable Long id) {
        Store store = service.findById(id);
        if(store != null) {
            service.deleteStore(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().build();
    }

}
