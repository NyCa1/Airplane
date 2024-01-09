package Service;


import DTO.ReservationDTO;
import Models.Reservations;
import Models.Tickets;
import Repository.ReservationRepository;
import Repository.TicketsRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import java.util.List;

@ApplicationScoped
public class ReservationService {
    @Inject
    ReservationRepository reservationRepository;
    @Inject
    TicketsRepository ticketsRepository;

    @Inject
    @Channel("reservations")
    Emitter<ReservationDTO>reservationsEmitter;
    public Reservations GetReservationById(Long id){return reservationRepository.GetReservationById(id);}

    public List<Reservations> GetAllReservations(){return reservationRepository.GetAllReservations();}

    public void SaveReservations(ReservationDTO reservationsRequest){
        Reservations reservation=new Reservations();

        reservation.setReservation_date_to(reservationsRequest.getReservation_date_to());
        reservation.setReservation_date_from(reservationsRequest.getReservation_date_from());

        Tickets ticketId=ticketsRepository.GetTicketById(reservationsRequest.getTicket_id());

        reservation.setTicket_id(ticketId);

        reservationRepository.SaveReservations(reservation);

        reservationsEmitter.send(reservationsRequest);



    }

    public void DeleteReservation(Long id){reservationRepository.DeleteReservation(id);}




}
