package cassandra.meetup.domain;

import com.datastax.driver.core.DataType;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Table("products")
public class Product implements Serializable {

    @PrimaryKey
    @CassandraType(type = DataType.Name.UUID)
    private UUID id;
    @Column(value = "name")
    private String name;
    @Column(value = "description")
    private String description;
    @Column(value = "price")
    private BigDecimal price;

    public Product() {
        id = UUID.randomUUID();
    }
}
