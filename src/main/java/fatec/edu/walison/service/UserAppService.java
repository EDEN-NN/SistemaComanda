package fatec.edu.walison.service;

import fatec.edu.walison.model.UserApp;
import fatec.edu.walison.repository.IUserApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserAppService implements UserDetailsService {

    @Autowired
    private IUserApp repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    public UserApp saveUser(UserApp user) {
        return this.repository.save(user);
    }

}
