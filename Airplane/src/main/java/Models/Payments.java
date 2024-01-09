package Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@NoArgsConstructor
@Getter
@Setter

public class Payments {
    @Id
    @SequenceGenerator(name = "sen_gen_payments",sequenceName = "payments_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sen_gen_payments")
    @Column(name = "payment_id")
    private short payment_id;
    @OneToOne
    @JoinColumn(name = "ticket_id")
    private Tickets ticket_id;
    @Column(name = "payment_date")
    private LocalDateTime payment_date;
    @Column(name = "payment_amount")
    private double payment_amount;
    @Column(name = "payment_method")
    private String payment_method;

    public Payments(Tickets ticket_id, LocalDateTime payment_date, double payment_amount, String payment_method) {
        this.ticket_id = ticket_id;
        this.payment_date = payment_date;
        this.payment_amount = payment_amount;
        this.payment_method = payment_method;
    }
}