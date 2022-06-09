package fatec.edu.walison.service;

import fatec.edu.walison.model.Role;
import fatec.edu.walison.repository.IRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    IRole repository;

    public Role saveRole(Role role) {
       return this.repository.save(role);
    }

}
