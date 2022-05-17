package suptech.miag.billservice.billing;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import suptech.miag.billservice.feign.CustomerRestService;
import suptech.miag.billservice.feign.ProductRestService;
import suptech.miag.billservice.model.Customer;
import suptech.miag.billservice.model.Product;

import java.time.LocalDate;

@Configuration
public class BillingConfig {
    private final BillRepository billRepository;
    private final ProductItemRepository productItemRepository;
    private final CustomerRestService customerRestService;
    private final ProductRestService productRestService;

    public BillingConfig(BillRepository billRepository, ProductItemRepository productItemRepository, CustomerRestService customerRestService, ProductRestService productRestService) {
        this.billRepository = billRepository;
        this.productItemRepository = productItemRepository;
        this.customerRestService = customerRestService;
        this.productRestService = productRestService;
    }

    @Bean
    CommandLineRunner init_billing(){
        return args -> {
            Customer customer = customerRestService.getCustomerById(1L);
            Product product1 = productRestService.getProductByRef("R001");
            Product product2 = productRestService.getProductByRef("R002");
            Product product3 = productRestService.getProductByRef("R004");
            Bill bill = billRepository.save(new Bill(null, LocalDate.now(),1L,customer,null));
            ProductItem productItem1 = productItemRepository.save(new ProductItem(null,2,product1.getPrice(),"R001",product1,bill));
            ProductItem productItem2 = productItemRepository.save(new ProductItem(null,3,product2.getPrice(),"R002",product2,bill));
            ProductItem productItem3 = productItemRepository.save(new ProductItem(null,1,product3.getPrice(),"R004",product3,bill));

        };
    }
}
