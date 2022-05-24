package suptech.miag.billservice.billing;

public interface IBillingService {
    Bill getBillDetails(long id) throws Exception;
}
