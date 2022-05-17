package fatec.edu.walison.service;

import fatec.edu.walison.model.Store;
import fatec.edu.walison.repository.IStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StoreService {

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

}
