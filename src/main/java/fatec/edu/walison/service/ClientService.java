package fatec.edu.walison.service;

import fatec.edu.walison.model.Client;
import fatec.edu.walison.repository.IClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
@Primary
public class ClientService implements UserDetailsService {

    @Autowired
    IClient repository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public List<Client> findAll() {
        return repository.findAll();
    }

    public Client findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException("User not found"));
    }

    public Client saveClient(Client client) {
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        return repository.save(client);
    }

    public void deleteClient(Long id) {
        Client client = this.findById(id);
        repository.deleteById(client.getUserId());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Client user = repository.findByUsername(username);
       if (user == null) {
           throw new UsernameNotFoundException("Username not found");
       }
       return new User(user.getUsername(), user.getPassword(), user.getAuthorities());
    }
}
