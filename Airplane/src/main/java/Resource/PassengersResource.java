package Resource;

import Models.Passengers;
import Service.PassengersService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;

import java.util.List;

@ApplicationScoped
@Path("/passengers")
public class PassengersResource {
    @Inject
    PassengersService passengersService;

    @Path("/getById/{id}")
    @GET
    @Produces("application/json")
    public Passengers getPassengerById(@PathParam("id")short id){return passengersService.GetPassengerById(id);}

    @Path("/getByFirstName/{firstName}")
    @GET
    @Produces("application/json")
    public Passengers getPassengerByFirstName(@PathParam("firstName")String firstName){return passengersService.GetPassengerByFirstName(firstName);}

    @Path("/getByLastName/{lastName}")
    @GET
    @Produces("application/json")
    public Passengers getPassengerByLastName(@PathParam("lastName")String lastName){return passengersService.GetPassengerByLastName(lastName);}

    @Path("getByPhone/{phone}")
    @GET
    @Produces("application/json")
    public Passengers getPassengerByPhone(@PathParam("phone")String phone){return passengersService.GetPassengerByPhone(phone);}

    @Path("getByMail/{mail}")
    @GET
    @Produces("application/json")
    public Passengers getPassengerByMail(@PathParam("mail")String mail){return passengersService.GetPassengerByMail(mail);}

    @Path("/post")
    @POST
    @Transactional
    @Produces("application/json")
    @Consumes("application/json")
    public void savePassengers(Passengers passengers){passengersService.SavePassengers(passengers);}

    @Path("")
    @GET
    @Produces("application/json")
    public List<Passengers> GetAllPassengers(){return passengersService.GetAllPassengers();}

    @Path("/delete/{id}")
    @DELETE
    @Transactional
    public void DeleteAllPassengers(@PathParam("id")Long id){passengersService.DeleteAllPassengers(id);}
}
