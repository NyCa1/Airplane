package Repository;


import Models.Passengers;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

@ApplicationScoped


public class PassengersRepository implements PanacheRepositoryBase<Passengers,Long> {

    public Passengers SavePassengers(Passengers passengers)
    {
        getEntityManager().persist(passengers);
        return passengers;
    }

    public List<Passengers> GetAllPassengers()
    {
        CriteriaBuilder builder= getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Passengers> query= builder.createQuery(Passengers.class);
        query.from(Passengers.class);

        return getEntityManager().createQuery(query).getResultList();
    }

    public Passengers GetPassengerById (short id)
    {
        CriteriaBuilder builder= getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Passengers> query= builder.createQuery(Passengers.class);
        Root<Passengers>root= query.from(Passengers.class);
        query.where(builder.equal(root.get("passengerId"),id));

        return getEntityManager().createQuery(query).getSingleResult();
    }

    public Passengers GetPassengerByFirstName (String firstName)
    {
        CriteriaBuilder builder= getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Passengers> query= builder.createQuery(Passengers.class);
        Root<Passengers>root= query.from(Passengers.class);
        query.where(builder.equal(root.get("firstName"),firstName));

        return getEntityManager().createQuery(query).getSingleResult();
    }

    public Passengers GetPassengerByLastName (String lastName)
    {
        CriteriaBuilder builder= getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Passengers> query= builder.createQuery(Passengers.class);
        Root<Passengers>root= query.from(Passengers.class);
        query.where(builder.equal(root.get("lastName"),lastName));

        return getEntityManager().createQuery(query).getSingleResult();
    }

    public Passengers GetPassengerByMail (String mail)
    {
        CriteriaBuilder builder= getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Passengers> query= builder.createQuery(Passengers.class);
        Root<Passengers>root= query.from(Passengers.class);
        query.where(builder.equal(root.get("email"),mail));

        return getEntityManager().createQuery(query).getSingleResult();
    }

    public Passengers GetPassengerByPhone (String phone)
    {
        CriteriaBuilder builder= getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Passengers> query= builder.createQuery(Passengers.class);
        Root<Passengers>root= query.from(Passengers.class);
        query.where(builder.equal(root.get("phoneNumber"),phone));

        return getEntityManager().createQuery(query).getSingleResult();
    }

    public void DeletePassengers(Long id)
    {
        CriteriaBuilder builder= getEntityManager().getCriteriaBuilder();
        CriteriaDelete<Passengers> delete=builder.createCriteriaDelete(Passengers.class);
        Root<Passengers>root=delete.from(Passengers.class);
        delete.where(builder.equal(root.get("passengerId"),id));

        getEntityManager().createQuery(delete).executeUpdate();
    }
}
