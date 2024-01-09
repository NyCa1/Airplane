package Service;


import Models.Airport;
import Repository.AirportRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped


public class AirportService {
    @Inject
    AirportRepository airportRepository;

    public Airport getAirportById(short id) {return airportRepository.getAirportById(id);}

    public Airport getAirportByName(String airportName) {return airportRepository.getAirportByName(airportName);}

    public void  DeleteAirport(Long id) {airportRepository.DeleteAirport(id);}

    public List<Airport> getAllAirports()
    {
        return airportRepository.getAllAirports();
    }

    public Airport saveAirport (Airport airport) {return airportRepository.SaveAirport(airport);}




}
