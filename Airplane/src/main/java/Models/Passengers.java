package Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="passengers")
@NoArgsConstructor
@Getter
@Setter
public class Passengers {

    @Id
    @SequenceGenerator(name = "seq_gen_passenger",sequenceName = "passenger_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_gen_passenger")
    @Column(name="passengers_id")
    private Short passengerId;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    private String email;
    @Column(name="phone_number")
    private String phoneNumber;

    public Passengers(String firstName, String lastName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
