package suptech.miag.customerservice.customer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfig {

    private final CustomerRepository customerRepository;

    public CustomerConfig(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Bean
    CommandLineRunner init_customer(){
        return args -> {
            if(customerRepository.count()==0) {
                customerRepository.save(new Customer(null, "chebihi", "chebihi@gmail.com"));
                customerRepository.save(new Customer(null, "sanaa", "sanaa@gmail.com"));
                customerRepository.save(new Customer(null, "ahmed", "ahmed@gmail.com"));
                customerRepository.save(new Customer(null, "ali", "ali@gmail.com"));
                customerRepository.save(new Customer(null, "ikram", "ikram@gmail.com"));
            }
        };
    }
}
