package Models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="airlines")
@NoArgsConstructor
@Getter
@Setter
public class Airline {

    @Id
    @SequenceGenerator(name = "seq_gen_airline",sequenceName = "airline_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_gen_airline")
    @Column(name = "airline_id")
    private short airlineId;
    @Column(name="airline_name")
    private String airlineName;

    public Airline(String airlineName) {
        this.airlineName = airlineName;
    }
}