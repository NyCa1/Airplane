package org.acme;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class Consumer {

    @Incoming("reservations")
    public void consume(ReservationsDTO reservations)
    {
        System.out.println(reservations);
    }
}
