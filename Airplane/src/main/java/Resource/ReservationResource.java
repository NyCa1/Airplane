package Resource;

import DTO.ReservationDTO;
import Models.Reservations;
import Service.ReservationService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;

import java.util.List;

@ApplicationScoped
@Path("/reservations")
public class ReservationResource {
    @Inject
    ReservationService reservationService;

    @Path("/GetById/{id}")
    @GET
    @Produces("application/json")
    public Reservations getReservationById(@PathParam("id")Long id){return reservationService.GetReservationById(id);}

    @Path("/post")
    @POST
    @Transactional
    @Produces("application/json")
    @Consumes("application/json")
    public void saveReservations(ReservationDTO reservations){reservationService.SaveReservations(reservations);}

    @Path("")
    @GET
    @Produces("application/json")
    public List<Reservations> GetAllReservations(){return reservationService.GetAllReservations();}

    @Path("/delete/{id}")
    @DELETE
    @Transactional
    public void DeleteReservation(@PathParam("id")Long id){reservationService.DeleteReservation(id);}
}
