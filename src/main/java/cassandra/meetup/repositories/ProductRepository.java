package cassandra.meetup.repositories;

import cassandra.meetup.domain.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;


public interface ProductRepository extends CrudRepository<Product, UUID> {
}
