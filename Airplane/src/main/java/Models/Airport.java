package Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "airport")
@NoArgsConstructor
@Getter
@Setter

public class Airport {
    @Id
    @SequenceGenerator(name = "sen_gen_airport",sequenceName = "airport_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sen_gen_airport")
    @Column(name = "airport_id")
    private short airport_id;
    @Column(name = "airport_name")
    private String AirportName;

    public Airport(String AirportName)
    {
        this.AirportName=AirportName;
    }
}

