package Resource;


import DTO.FlightDTO;
import Models.Flights;
import Service.FlightsService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;

import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
@Path("/flights")
public class FlightsResource {
    @Inject
    FlightsService flightsService;

    @Path("/GetById/{id}")
    @GET
    @Produces("application/json")
    public Flights getFlightById(@PathParam("id")short id){return flightsService.GetFlightById(id);}

    @Path("GetByArrivalTime/{arrTime}")
    @GET
    @Produces("application/json")
    public Flights GetFlightByArrivalTime(@PathParam("arrTime")LocalDateTime arrTime){return flightsService.GetFlightByArrivalTime(arrTime);}

    @Path("/post")
    @POST
    @Transactional
    @Produces("application/json")
    @Consumes("application/json")
    public void SaveFlights(FlightDTO flights){flightsService.SaveFlights(flights);}

    @Path("/delete/{id}")
    @DELETE
    @Transactional
    public void DeleteFlight(@PathParam("id")Long id){flightsService.DeleteFlight(id);}

    @Path("")
    @GET
    @Produces("application/json")
    public List<Flights> GetAllFlights(){return flightsService.GetAllFlights();}




}

