package Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "flights")
@NoArgsConstructor
@Getter
@Setter

public class Flights {
    @Id
    @SequenceGenerator(name = "sen_gen_flights",sequenceName = "flights_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sen_gen_flights")
    @Column(name = "flight_id")
    private short flight_id;
    @ManyToOne
    @JoinColumn(name = "departure_airport_id")
    private Airport departure_airport;
    @ManyToOne
    @JoinColumn(name = "arrival_airport_id")
    private Airport arrival_airport;
    @Column(name = "departure_time")
    private LocalDateTime departure_time;
    @Column(name = "arrival_time")
    private LocalDateTime arrival_time;
    @ManyToOne
    @JoinColumn(name = "airline_id")
    private Airline airline;

    public Flights(Airport departure_airport, Airport arrival_airport, LocalDateTime departure_time, LocalDateTime arrival_time) {
        this.departure_airport = departure_airport;
        this.arrival_airport = arrival_airport;
        this.departure_time = departure_time;
        this.arrival_time = arrival_time;
    }
}