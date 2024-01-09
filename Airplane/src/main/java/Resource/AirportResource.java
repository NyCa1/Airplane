package Resource;

import Models.Airport;
import Service.AirportService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;

import java.util.List;

@ApplicationScoped
@Path("/airport")
public class AirportResource {
    @Inject
    AirportService airportService;

    @Path("/getById/{id}")
    @GET
    @Produces("application/json")
    public Airport getAirportById(@PathParam("id")short id) {return airportService.getAirportById(id);}

    @Path("/post")
    @POST
    @Transactional
    @Produces("application/json")
    @Consumes("application/json")
    public Airport SaveAirport (Airport airport) {return airportService.saveAirport(airport);}

    @Path("")
    @GET
    @Produces("application/json")
    public List<Airport> getAllAirplanes(){return airportService.getAllAirports();}

    @Path("/getByName/{Name}")
    @GET
    @Produces("application/json")
    public Airport getAirportByName (@PathParam("Name")String airportName)
    {
        return airportService.getAirportByName(airportName);
    }

    @Path("/delete/{id}")
    @DELETE
    @Transactional
    public void DeleteAirport(@PathParam("id")Long id)
    {
        airportService.DeleteAirport(id);
    }

}
