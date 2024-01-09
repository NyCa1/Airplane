package Resource;

import DTO.TicketDTO;
import Models.Tickets;
import Service.TicketsService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;

@ApplicationScoped
@Path("/tickets")
public class TicketsResource {
    @Inject
    TicketsService ticketsService;

    @Path("/GetById/{id}")
    @GET
    @Produces("application/json")
    public Tickets getTicketById(@PathParam("id")short id){return ticketsService.GetTicketById(id);}

    @Path("/post")
    @POST
    @Transactional
    @Produces("application/json")
    @Consumes("application/json")
    public void SaveTickets(TicketDTO tickets){ticketsService.SaveTickets(tickets);}

    @Path("/delete/{id}")
    @DELETE
    @Transactional
    public void DeleteTicket(@PathParam("id")Long id){ticketsService.DeleteTicket(id);}

    @Path("/GetByPassenger/{passenger_id}")
    @GET
    @Produces("application/json")
    public Tickets GetTicketByPassenger(@PathParam("passenger_id")Long id){return ticketsService.GetTicketByPassenger(id);}

    @Path("/GetByFlight/{ticket_id}")
    @GET
    @Produces("application/json")
    public Tickets GetTicketByFlight(@PathParam("ticket_id")Long id){return ticketsService.GetTicketByFlight(id);}


}
