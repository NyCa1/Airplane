package org.acme;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ReservationsDTO {
    private short reservation_id;
    private LocalDateTime reservation_date_from;
    private LocalDateTime reservation_date_to;
    private short ticket_id;

}
