package Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "reservations")
@NoArgsConstructor
@Getter
@Setter

public class Reservations {
    @Id
    @SequenceGenerator(name = "sen_gen_reservations",sequenceName = "reservations_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sen_gen_reservations")
    @Column(name = "reservation_id")
    private short reservation_id;
    @OneToOne
    @JoinColumn(name = "ticket_id")
    private Tickets ticket_id;
    @Column(name = "reservation_date_from")
    private LocalDateTime reservation_date_from;
    @Column(name = "reservation_date_to")
    private LocalDateTime reservation_date_to;


    public Reservations(Tickets ticket_id, LocalDateTime reservation_date_from, LocalDateTime reservation_date_to) {
        this.ticket_id = ticket_id;
        this.reservation_date_from = reservation_date_from;
        this.reservation_date_to = reservation_date_to;
    }
}
