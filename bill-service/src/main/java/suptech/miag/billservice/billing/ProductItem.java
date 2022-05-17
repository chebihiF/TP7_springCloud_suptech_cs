package suptech.miag.billservice.billing;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import suptech.miag.billservice.model.Product;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductItem {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id ;
    private int quantity ;
    private double price ;
    private String productRef ;
    @Transient
    private Product product;
    @ManyToOne
    private Bill bill;
}
