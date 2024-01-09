package Repository;


import Models.Flights;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class FlightsRepository implements PanacheRepositoryBase<Flights,Long> {

    public void SaveFlights(Flights flights)
    {
        getEntityManager().persist(flights);

    }

    public List<Flights> GetAllFlights()
    {
        CriteriaBuilder builder= getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Flights> query= builder.createQuery(Flights.class);
        query.from(Flights.class);

        return getEntityManager().createQuery(query).getResultList();
    }

    public Flights GetFlightById(short id)
    {
        CriteriaBuilder builder= getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Flights> query= builder.createQuery(Flights.class);
        Root<Flights>root= query.from(Flights.class);
        query.where(builder.equal(root.get("flight_id"),id));

        return getEntityManager().createQuery(query).getSingleResult();
    }

    public Flights GetFlightByDepartureTime(LocalDateTime depTime)
    {
        CriteriaBuilder builder= getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Flights> query=builder.createQuery(Flights.class);
        Root<Flights>root=query.from(Flights.class);
        query.where(builder.equal(root.get("departure_time"),depTime));

        return getEntityManager().createQuery(query).getSingleResult();
    }

    public Flights GetFlightByArrivalTime(LocalDateTime arrTime)
    {
        CriteriaBuilder builder= getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Flights> query=builder.createQuery(Flights.class);
        Root<Flights>root=query.from(Flights.class);
        query.where(builder.equal(root.get("arrival_time"),arrTime));

        return getEntityManager().createQuery(query).getSingleResult();
    }

    public List<Flights> GetFlightByDepartureAirportID(Long airport_id)
    {
        CriteriaBuilder builder= getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Flights> query=builder.createQuery(Flights.class);
        Root<Flights>root=query.from(Flights.class);
        query.where(builder.equal(root.get("departure_airport").get("airport_id"),airport_id));

        return getEntityManager().createQuery(query).getResultList();


    }

    public List<Flights> GetFlightByArrivalAirportID(Long airport_id)
    {
        CriteriaBuilder builder= getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Flights> query=builder.createQuery(Flights.class);
        Root<Flights>root=query.from(Flights.class);
        query.where(builder.equal(root.get("arrival_airport").get("airport_id"),airport_id));

        return getEntityManager().createQuery(query).getResultList();
    }

    public void DeleteFlight(Long id)
    {
        CriteriaBuilder builder= getEntityManager().getCriteriaBuilder();
        CriteriaDelete<Flights> delete=builder.createCriteriaDelete(Flights.class);
        Root<Flights>root=delete.from(Flights.class);
        delete.where(builder.equal(root.get("flight_id"),id));

        getEntityManager().createQuery(delete).executeUpdate();
    }




}
