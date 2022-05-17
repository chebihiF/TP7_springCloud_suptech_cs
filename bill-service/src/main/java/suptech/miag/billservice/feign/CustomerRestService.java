package suptech.miag.billservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import suptech.miag.billservice.model.Customer;

@FeignClient(name="CUSTOMER-SERVICE")
public interface CustomerRestService {
    @GetMapping("/customers/{id}")
    Customer getCustomerById(@PathVariable(name = "id") Long id);
}
