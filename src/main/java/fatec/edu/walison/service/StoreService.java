package fatec.edu.walison.service;

import fatec.edu.walison.model.Employee;
import fatec.edu.walison.model.Store;
import fatec.edu.walison.repository.IStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service

public class StoreService implements UserDetailsService {

    @Autowired
    IStore repository;

    public List<Store> findAll() {
        return repository.findAll();
    }

    public Store findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException("Store not found"));
    }

    public Store saveStore(Store Store) {
        return repository.save(Store);
    }

    public void deleteStore(Long id) {
        Store Store = this.findById(id);
        repository.deleteById(Store.getUserId());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Store user = repository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Username not found");
        }
        return new User(user.getUsername(), user.getPassword(), user.getAuthorities());
    }

}
