package suptech.miag.proxyserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProxyServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProxyServerApplication.class, args);
    }

    @Bean
    RouteLocator routeLocator(RouteLocatorBuilder builder){
        return builder
                .routes()
                .route(r->r
                        .path("/vlib/**")
                        .uri("https://opendata.paris.fr/api/v2/")
                )
                .route(r->r
                        .path("/posts/**")
                        .uri("https://jsonplaceholder.typicode.com/posts")
                )
                .build();
    }

    @Bean
    DiscoveryClientRouteDefinitionLocator definitionLocator
            (ReactiveDiscoveryClient rdc, DiscoveryLocatorProperties properties){
        return new DiscoveryClientRouteDefinitionLocator(rdc,properties);
    }

}
