package Service;

import Models.Payments;
import Repository.PaymentsRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped

public class PaymentsService {
    @Inject
    PaymentsRepository paymentsRepository;

    public Payments GetPaymentById(Long id){return paymentsRepository.GetPaymentById(id);}

    public List<Payments> GetAllPayments(){return paymentsRepository.GetAllPayments();}

    public Payments SavePayments(Payments payments){return paymentsRepository.savePayments(payments);}

    public void DeletePayment(Long id){paymentsRepository.DeletePayment(id);}

    public Payments GetPaymentByTicket(Long id){return paymentsRepository.GetPaymentByTicket(id);}
}
