package Resource;

import Models.Payments;
import Service.PaymentsService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;

import java.util.List;

@ApplicationScoped
@Path("/payments")

public class PaymentsResource {
    @Inject
    PaymentsService paymentsService;

    @Path("GetById/{id}")
    @GET
    @Produces("application/json")
    public Payments getPaymentById(@PathParam("id")Long id){return paymentsService.GetPaymentById(id);}

    @Path("/post")
    @POST
    @Transactional
    @Produces("application/json")
    @Consumes("application/json")
    public Payments SavePayments(Payments payments){return paymentsService.SavePayments(payments);}

    @Path("/delete/{id}")
    @DELETE
    @Transactional
    public void DeleteFlight(@PathParam("id")Long id){paymentsService.DeletePayment(id);}

    @Path("")
    @GET
    @Produces("application/json")
    public List<Payments> GetAllPayments(){return paymentsService.GetAllPayments();}

    @Path("GetByTicket/{id}")
    @GET
    @Produces("application/json")
    public Payments GetPassengerByTicket(@PathParam("id")Long id){return paymentsService.GetPaymentByTicket(id);}


}
