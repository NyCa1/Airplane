package Service;


import DTO.TicketDTO;
import Models.Flights;
import Models.Passengers;
import Models.Tickets;
import Repository.FlightsRepository;
import Repository.PassengersRepository;
import Repository.TicketsRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped

public class TicketsService {
    @Inject
    TicketsRepository ticketsRepository;

    @Inject
    PassengersRepository passengersRepository;

    @Inject
    FlightsRepository flightsRepository;

    public Tickets GetTicketById (short id){return ticketsRepository.GetTicketById(id);}

    public List<Tickets> GetAllTickets(){return ticketsRepository.GetAllTickets();}

    public void SaveTickets(TicketDTO request){
        Tickets ticket=new Tickets();

        ticket.setSeat_number(request.getSeat_number());
        ticket.setPurchase_date(request.getPurchase_date());
        ticket.setTicket_price(request.getTicket_price());

        Flights flightId=flightsRepository.GetFlightById(request.getFlight_id());
        Passengers passengerId=passengersRepository.GetPassengerById(request.getPassengers_id());
        ticket.setFlight_id(flightId);
        ticket.setPassenger_id(passengerId);

        ticketsRepository.SaveTickets(ticket);



    }

    public void DeleteTicket(Long id) {ticketsRepository.DeleteTicket(id);}

    public Tickets GetTicketByPassenger(Long id) {return ticketsRepository.GetTicketByPassenger(id);}

    public Tickets GetTicketByFlight(Long id){return ticketsRepository.GetTicketByFlight(id);}



}
