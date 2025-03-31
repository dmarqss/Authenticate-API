package estudoLogin.springSecurity.model.product;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@NoArgsConstructor
@Getter
@Setter
@Data
public class Product{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    String name;
    @Column(nullable = false)
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
