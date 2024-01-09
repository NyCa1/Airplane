package Repository;


import Models.Airline;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

@ApplicationScoped
public class AirlineRepository implements PanacheRepositoryBase <Airline,Long> {


    public Airline saveAirline(Airline airline)
    {
        getEntityManager().persist(airline);
        getEntityManager().flush();
        getEntityManager().refresh(airline);
        return airline;
    }

    public List<Airline> getAllAirlines()
    {
        CriteriaBuilder builder= getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Airline> query= builder.createQuery(Airline.class);
        query.from(Airline.class);

        return getEntityManager().createQuery(query).getResultList();


    }

    public Airline getAirlinebyId(short id)
    {
        CriteriaBuilder builder= getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Airline> query=builder.createQuery(Airline.class);
        Root<Airline>root= query.from(Airline.class);
        query.where(builder.equal(root.get("airlineId"),id));

        return getEntityManager().createQuery(query).getSingleResult();
    }

    public Airline getAirlineByName(String airlineName)
    {
        CriteriaBuilder builder= getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Airline> query=builder.createQuery(Airline.class);
        Root<Airline>root=query.from(Airline.class);
        query.where(builder.equal(root.get("airlineName"),airlineName));

        return getEntityManager().createQuery(query).getSingleResult();
    }

    public void deleteAirline(Long id)
    {
        CriteriaBuilder builder= getEntityManager().getCriteriaBuilder();
        CriteriaDelete<Airline>delete= builder.createCriteriaDelete(Airline.class);
        Root<Airline>root=delete.from(Airline.class);
        delete.where(builder.equal(root.get("airlineId"),id));

        getEntityManager().createQuery(delete).executeUpdate();
    }
}