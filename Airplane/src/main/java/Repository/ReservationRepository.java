package Repository;


import Models.Reservations;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

@ApplicationScoped
public class ReservationRepository implements PanacheRepositoryBase<Reservations,Long> {

    public void SaveReservations(Reservations reservations)
    {
        getEntityManager().persist(reservations);
    }

    public List<Reservations> GetAllReservations()
    {
        CriteriaBuilder builder= getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Reservations> query= builder.createQuery(Reservations.class);
        query.from(Reservations.class);

        return getEntityManager().createQuery(query).getResultList();
    }

    public Reservations GetReservationById(Long id)
    {
        CriteriaBuilder builder= getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Reservations> query=builder.createQuery(Reservations.class);
        Root<Reservations>root=query.from(Reservations.class);
        query.where(builder.equal(root.get("reservation_id"),id));

        return getEntityManager().createQuery(query).getSingleResult();
    }

    public void DeleteReservation(Long id)
    {
        CriteriaBuilder builder= getEntityManager().getCriteriaBuilder();
        CriteriaDelete<Reservations> delete=builder.createCriteriaDelete(Reservations.class);
        Root<Reservations>root=delete.from(Reservations.class);
        delete.where(builder.equal(root.get("reservation_id"),id));

        getEntityManager().createQuery(delete).executeUpdate();
    }

    public Reservations GetReservationByTicket(Long id)
    {
        CriteriaBuilder builder= getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Reservations> query=builder.createQuery(Reservations.class);
        Root<Reservations>root=query.from(Reservations.class);
        query.where(builder.equal(root.get("ticket_id"),id));

        return getEntityManager().createQuery(query).getSingleResult();
    }
}
