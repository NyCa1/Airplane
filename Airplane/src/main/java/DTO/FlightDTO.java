package DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightDTO {
    private Short flight_id;
    private Short departure_airport_id;
    private Short arrival_airport_id;
    private LocalDateTime departure_time;
    private LocalDateTime arrival_time;
    private Short airline_id;
}
