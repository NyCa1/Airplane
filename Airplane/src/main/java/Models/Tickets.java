package Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
@NoArgsConstructor
@Getter
@Setter

public class Tickets {
    @Id
    @SequenceGenerator(name = "sen_gen_tickets",sequenceName = "tickets_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sen_gen_tickets")
    @Column(name = "ticket_id")
    private short ticket_id;
    @OneToOne
    @JoinColumn(name = "passengers_id")
    private Passengers passenger_id;
    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flights flight_id;
    @Column(name = "seat_number")
    private String seat_number;
    @Column(name = "ticket_price")
    private double ticket_price;
    @Column(name = "purchase_date")
    private LocalDateTime purchase_date;

    public Tickets(Passengers passenger_id, Flights flight_id, String seat_number, double ticket_price, LocalDateTime purchase_date) {
        this.passenger_id = passenger_id;
        this.flight_id = flight_id;
        this.seat_number = seat_number;
        this.ticket_price = ticket_price;
        this.purchase_date = purchase_date;
    }
}
