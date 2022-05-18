package fatec.edu.walison.controller;

import fatec.edu.walison.model.Client;
import fatec.edu.walison.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    ClientService service;

    @GetMapping
    public ResponseEntity<List<Client>> findAll() {
        List<Client> clients = service.findAll();
        return ResponseEntity.ok().body(clients);
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<Client> findClient(@PathVariable Long id) {
        Client client = service.findById(id);
        return ResponseEntity.ok().body(client);
    }

    @PutMapping("/client/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client client) {
        Client newClient = service.findById(id);
        service.saveClient(newClient);
        return ResponseEntity.accepted().body(newClient);
    }

    @PostMapping("/client/create")
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        client = service.saveClient(client);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(client.getUserId()).toUri();
        return ResponseEntity.created(uri).body(client);
    }

    @DeleteMapping("/client/delete/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
       Client client = service.findById(id);
       if(client != null) {
           service.deleteClient(id);
           return ResponseEntity.noContent().build();
       }
       return ResponseEntity.badRequest().build();
    }

}
