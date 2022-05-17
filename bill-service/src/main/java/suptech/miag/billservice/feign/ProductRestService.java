package suptech.miag.billservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import suptech.miag.billservice.model.Product;

@FeignClient(name = "PRODUCT-SERVICE")
public interface ProductRestService {
    @GetMapping("/products")
    PagedModel<Product> pageProducts(@RequestParam(value = "page") int page, @RequestParam(value = "size") int size);
    @GetMapping("/product/{ref}")
    Product getProductByRef(@PathVariable String ref);
}
