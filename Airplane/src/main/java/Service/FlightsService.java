package Service;

import DTO.FlightDTO;
import Models.Airline;
import Models.Airport;
import Models.Flights;
import Repository.AirlineRepository;
import Repository.AirportRepository;
import Repository.FlightsRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped

public class FlightsService {
    @Inject
    FlightsRepository flightsRepository;
    @Inject
    AirportRepository airportRepository;

    @Inject
    AirlineRepository airlineRepository;

    public Flights GetFlightById (short id){return  flightsRepository.GetFlightById(id);}

    public List<Flights> GetAllFlights(){return flightsRepository.GetAllFlights();}

    public void SaveFlights(FlightDTO flights){

        Flights flight = new Flights();
        flight.setDeparture_time(flights.getDeparture_time());
        flight.setArrival_time(flights.getArrival_time());

        Airport departure=airportRepository.getAirportById(flights.getDeparture_airport_id());
        Airport arrival=airportRepository.getAirportById(flights.getArrival_airport_id());
        flight.setDeparture_airport(departure);
        flight.setArrival_airport(arrival);
        Airline airline=airlineRepository.getAirlinebyId(flights.getAirline_id());
        flight.setAirline(airline);

        flightsRepository.SaveFlights(flight);


    }

    public Flights GetFlightByDepartureTime(LocalDateTime depTime){return flightsRepository.GetFlightByDepartureTime(depTime);}

    public Flights GetFlightByArrivalTime(LocalDateTime arrTime){return flightsRepository.GetFlightByArrivalTime(arrTime);}

    public List<Flights> GetFlightByDepartureAirportID(Long airport_id){return flightsRepository.GetFlightByDepartureAirportID(airport_id);}

    public List<Flights> GetFlightByArrivalAirportID(Long airport_id){return flightsRepository.GetFlightByArrivalAirportID(airport_id);}

    public void DeleteFlight(Long id){flightsRepository.DeleteFlight(id);}
}
