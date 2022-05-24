package suptech.miag.billservice.billing;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bills/")
public class BillController {

    private final IBillingService billingService;

    public BillController(IBillingService billingService) {
        this.billingService = billingService;
    }

    @GetMapping("/details/{id}")
    public Bill getBillDetails(@PathVariable Long id){
        try {
            return billingService.getBillDetails(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
