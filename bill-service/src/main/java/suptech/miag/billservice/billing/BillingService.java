package suptech.miag.billservice.billing;

import org.springframework.stereotype.Service;
import suptech.miag.billservice.feign.CustomerRestService;
import suptech.miag.billservice.feign.ProductRestService;

import java.util.Optional;

@Service
public class BillingService implements IBillingService{

    private final BillRepository billRepository;
    private final CustomerRestService customerRestService;
    private final ProductRestService productRestService;

    public BillingService(BillRepository billRepository, CustomerRestService customerRestService, ProductRestService productRestService) {
        this.billRepository = billRepository;
        this.customerRestService = customerRestService;
        this.productRestService = productRestService;
    }

    @Override
    public Bill getBillDetails(long id) throws Exception {
        Optional<Bill> billOptional = billRepository.findById(id);
        if(billOptional.isEmpty())
            throw new RuntimeException("bill "+id+" cannot be found");
        Bill bill = billOptional.get();
        bill.setCustomer(customerRestService.getCustomerById(bill.getCustomerID()));
        bill.getProductItems().forEach(
                productItem -> productItem.setProduct(productRestService.getProductByRef(productItem.getProductRef())));
        return bill;
    }
}
