package Repository;


import Models.Tickets;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

@ApplicationScoped

public class TicketsRepository implements PanacheRepositoryBase<Tickets,Long> {

    public void SaveTickets(Tickets tickets)
    {
        getEntityManager().persist(tickets);

    }

    public List<Tickets> GetAllTickets()
    {
        CriteriaBuilder builder=getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Tickets> query= builder.createQuery(Tickets.class);
        query.from(Tickets.class);

        return getEntityManager().createQuery(query).getResultList();
    }

    public Tickets GetTicketById(short id)
    {
        CriteriaBuilder builder=getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Tickets> query=builder.createQuery(Tickets.class);
        Root<Tickets>root=query.from(Tickets.class);
        query.where(builder.equal(root.get("ticket_id"),id));

        return getEntityManager().createQuery(query).getSingleResult();
    }

    public void DeleteTicket(Long id)
    {
        CriteriaBuilder builder=getEntityManager().getCriteriaBuilder();
        CriteriaDelete<Tickets> delete=builder.createCriteriaDelete(Tickets.class);
        Root<Tickets>root=delete.from(Tickets.class);
        delete.where(builder.equal(root.get("ticket_id"),id));

        getEntityManager().createQuery(delete).executeUpdate();
    }

    public Tickets GetTicketByPassenger(Long id)
    {
        CriteriaBuilder builder=getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Tickets> query=builder.createQuery(Tickets.class);
        Root<Tickets>root=query.from(Tickets.class);
        query.where(builder.equal(root.get("passenger_id"),id));

        return getEntityManager().createQuery(query).getSingleResult();
    }

    public Tickets GetTicketByFlight(Long id)
    {
        CriteriaBuilder builder=getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Tickets> query=builder.createQuery(Tickets.class);
        Root<Tickets>root=query.from(Tickets.class);
        query.where(builder.equal(root.get("flight_id"),id));

        return getEntityManager().createQuery(query).getSingleResult();
    }
}

