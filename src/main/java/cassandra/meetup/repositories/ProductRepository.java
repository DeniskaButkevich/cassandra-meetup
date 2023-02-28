package cassandra.meetup.repositories;

import cassandra.meetup.domain.Product;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;


public interface ProductRepository extends CrudRepository<Product, UUID> {
    List<Product> findAllByPrice(BigDecimal price);
}
