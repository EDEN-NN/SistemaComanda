package fatec.edu.walison.controller;

import fatec.edu.walison.model.UserApp;
import fatec.edu.walison.service.UserAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/user")
public class UserAppController {

    @Autowired
    private UserAppService service;

    @PutMapping("/signup")
    public ResponseEntity<UserApp> saveUser(@RequestBody UserApp user) {
        user = service.saveUser(user);
        URI uri = ServletUriComponentsBuilder.
                fromCurrentRequest().
                path("/{id}").
                buildAndExpand(user.getUserId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
