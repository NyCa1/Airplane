package DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TicketDTO {
    private Short ticket_id;
    private String seat_number;
    private double ticket_price;
    private LocalDateTime purchase_date;
    private Short flight_id;
    private Short passengers_id;

}
