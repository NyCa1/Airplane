package Repository;

import Models.Airport;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

@ApplicationScoped
public class AirportRepository implements PanacheRepositoryBase<Airport, Long> {

    public Airport SaveAirport(Airport airport)
    {
        getEntityManager().persist(airport);
        getEntityManager().flush();
        getEntityManager().refresh(airport);
        return airport;
    }

    public List<Airport> getAllAirports()
    {
        CriteriaBuilder builder= getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Airport> query= builder.createQuery(Airport.class);
        query.from(Airport.class);

        return getEntityManager().createQuery(query).getResultList();
    }

    public Airport getAirportById(short id)
    {
        CriteriaBuilder builder= getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Airport> query=builder.createQuery(Airport.class);
        Root<Airport>root= query.from(Airport.class);
        query.where(builder.equal(root.get("airport_id"),id));

        return getEntityManager().createQuery(query).getSingleResult();
    }

    public Airport getAirportByName(String airportName)
    {
        CriteriaBuilder builder= getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Airport> query= builder.createQuery(Airport.class);
        Root<Airport>root=query.from(Airport.class);
        query.where(builder.equal(root.get("AirportName"),airportName));

        return getEntityManager().createQuery(query).getSingleResult();
    }

    public void DeleteAirport(long id)
    {
        CriteriaBuilder builder= getEntityManager().getCriteriaBuilder();
        CriteriaDelete<Airport>delete=builder.createCriteriaDelete(Airport.class);
        Root<Airport>root=delete.from(Airport.class);
        delete.where(builder.equal(root.get("airport_id"),id));

        getEntityManager().createQuery(delete).executeUpdate();
    }



}
