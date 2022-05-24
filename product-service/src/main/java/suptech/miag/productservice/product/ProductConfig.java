package suptech.miag.productservice.product;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@Configuration
public class ProductConfig {
    private final ProductRepository productRepository;
    private final RepositoryRestConfiguration configuration ;

    public ProductConfig(ProductRepository productRepository, RepositoryRestConfiguration configuration) {
        this.productRepository = productRepository;
        this.configuration = configuration;
    }

    @Bean
    CommandLineRunner init_products(){
        return args -> {
          configuration.exposeIdsFor(Product.class);
          productRepository.save(new Product("R001","IphoneXX",10,15000));
          productRepository.save(new Product("R002","note 12",100,13000));
          productRepository.save(new Product("R003","TV Sumsung",200,5000));
          productRepository.save(new Product("R004","Iwatch",100,5000));
          productRepository.save(new Product("R005","galaxy watch",10,3000));
        };
    }
}
