package suptech.miag.customerservice.customer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@Configuration
public class CustomerConfig {

    private final CustomerRepository customerRepository;
    private final RepositoryRestConfiguration configuration ;

    public CustomerConfig(CustomerRepository customerRepository, RepositoryRestConfiguration configuration) {
        this.customerRepository = customerRepository;
        this.configuration = configuration;
    }

    @Bean
    CommandLineRunner init_customer(){
        return args -> {
            configuration.exposeIdsFor(Customer.class);
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
