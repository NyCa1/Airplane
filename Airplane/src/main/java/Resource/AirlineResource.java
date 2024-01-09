package Resource;


import Models.Airline;
import Service.AirlineService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;

import java.util.List;

@ApplicationScoped
@Path("/airline")
public class AirlineResource {
    @Inject
    AirlineService airlineService;

    @Path("/getById/{id}")
    @GET
    @Produces("application/json")
    public Airline getAirlineById(@PathParam("id")short id)
    {
        return airlineService.getAirlineById(id);
    }

    @Path("/getByName/{Name}")
    @GET
    @Produces("application/json")
    public Airline getAirlineByName(@PathParam("Name")String airlineName)
    {
        return airlineService.getAirlineByName(airlineName);
    }

    @Path("")
    @GET
    @Produces("application/json")
    public List<Airline> getAllAirlines()
    {
        return airlineService.getAllAirlines();
    }

    @Path("/delete/{id}")
    @DELETE
    @Transactional
    public void DeleteAirLine(@PathParam("id")Long id)
    {
        airlineService.DeleteAirline(id);
    }

    @Path("/post")
    @POST
    @Transactional
    @Produces("application/json")
    @Consumes("application/json")
    public Airline saveAirline(Airline airline)
    {
        return airlineService.saveAirline(airline);
    }

}
