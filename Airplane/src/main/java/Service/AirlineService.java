package Service;

import Models.Airline;
import Repository.AirlineRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped

public class AirlineService {
    @Inject
    AirlineRepository airlineRepository;

    public Airline getAirlineById(short id)
    {
        return airlineRepository.getAirlinebyId(id);
    }

    public Airline getAirlineByName(String airlineName)
    {
        return airlineRepository.getAirlineByName(airlineName);
    }

    public void DeleteAirline(Long id)
    {
        airlineRepository.deleteAirline(id);
    }

    public List<Airline> getAllAirlines()
    {
        return airlineRepository.getAllAirlines();
    }

    public Airline saveAirline(Airline airline)
    {
        return airlineRepository.saveAirline(airline);
    }

}
