package cassandra.meetup.services;

import cassandra.meetup.domain.Product;
import cassandra.meetup.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public List<Product> listAll() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

    public Product getById(UUID id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product saveOrUpdate(Product product) {
        return productRepository.save(product);
    }

    public void delete(UUID id) {
        productRepository.deleteById(id);

    }

    public Product saveOrUpdateProductForm(Product product) {
        Product savedProduct = saveOrUpdate(product);
        System.out.println("Saved Product Id: " + savedProduct.getId());
        return savedProduct;
    }
}
