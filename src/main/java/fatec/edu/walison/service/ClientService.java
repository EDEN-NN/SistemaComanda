package fatec.edu.walison.service;

import fatec.edu.walison.model.Client;
import fatec.edu.walison.repository.IClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ClientService {

    @Autowired
    IClient repository;

    public List<Client> findAll() {
        return repository.findAll();
    }

    public Client findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException("User not found"));
    }

    public Client saveClient(Client client) {
        return repository.save(client);
    }

    public void deleteClient(Long id) {
        Client client = this.findById(id);
        repository.deleteById(client.getUserId());
    }

}
