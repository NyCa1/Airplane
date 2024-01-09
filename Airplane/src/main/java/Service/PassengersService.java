package Service;

import Models.Passengers;
import Repository.PassengersRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped


public class PassengersService {
    @Inject
    PassengersRepository passengersRepository;

    public Passengers GetPassengerById(short id){return passengersRepository.GetPassengerById(id);}

    public Passengers GetPassengerByFirstName(String firstName){return passengersRepository.GetPassengerByFirstName(firstName);}

    public Passengers GetPassengerByLastName(String lastName){return passengersRepository.GetPassengerByLastName(lastName);}

    public Passengers GetPassengerByPhone(String phone){return passengersRepository.GetPassengerByPhone(phone);}

    public Passengers GetPassengerByMail(String mail){return passengersRepository.GetPassengerByMail(mail);}

    public List<Passengers> GetAllPassengers(){return passengersRepository.GetAllPassengers();}

    public void DeleteAllPassengers(Long id){passengersRepository.DeletePassengers(id);}

    public Passengers SavePassengers(Passengers passengers){return passengersRepository.SavePassengers(passengers);}
}
