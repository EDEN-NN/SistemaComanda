package fatec.edu.walison.controller;

import fatec.edu.walison.exception.UsernameAlreadyInUseException;
import fatec.edu.walison.model.Client;
import fatec.edu.walison.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    ClientService service;

    @GetMapping
    public ResponseEntity<List<Client>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<Client> findClient(@PathVariable Long id) {
        Client client = service.findById(id);
        return ResponseEntity.ok().body(client);
    }

    @PostMapping("/signup")
    public ResponseEntity<Client> saveClient(@RequestBody Client client) {
        UserDetails user = service.loadUserByUsername(client.getUsername());
        if (user == null) {
            service.saveClient(client);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(client.getUserId()).toUri();
            return ResponseEntity.created(uri).build();
        }
       throw new UsernameAlreadyInUseException("Username is already in use");
    }

    @PutMapping("/client/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client client) {
        return ResponseEntity.ok().body(service.saveClient(client));
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
