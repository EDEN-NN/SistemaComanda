package fatec.edu.walison.service;

import fatec.edu.walison.model.Product;
import fatec.edu.walison.repository.IProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductService {

    @Autowired
    IProduct repository;

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException("Product not found"));
    }

    public Product saveProduct(Product Product) {
        return repository.save(Product);
    }

    public void deleteProduct(Long id) {
        Product Product = this.findById(id);
        repository.deleteById(Product.getProductId());
    }

}
