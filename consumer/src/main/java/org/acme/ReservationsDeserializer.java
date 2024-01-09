package org.acme;

import io.quarkus.kafka.client.serialization.JsonbDeserializer;

public class ReservationsDeserializer extends JsonbDeserializer<ReservationsDTO> {
    public ReservationsDeserializer()
    {
        super(ReservationsDTO.class);
    }
}
