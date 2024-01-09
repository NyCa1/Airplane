package Repository;


import Models.Payments;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

@ApplicationScoped
public class PaymentsRepository implements PanacheRepositoryBase<Payments,Long> {
    public Payments savePayments(Payments payments)
    {
        getEntityManager().persist(payments);
        return payments;
    }

    public List<Payments> GetAllPayments()
    {
        CriteriaBuilder builder=getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Payments> query=builder.createQuery(Payments.class);
        query.from(Payments.class);

        return getEntityManager().createQuery(query).getResultList();

    }

    public Payments GetPaymentById(Long id)
    {
        CriteriaBuilder builder=getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Payments> query=builder.createQuery(Payments.class);
        Root<Payments>root=query.from(Payments.class);
        query.where(builder.equal(root.get("payment_id"),id));

        return getEntityManager().createQuery(query).getSingleResult();

    }

    public void DeletePayment(Long id)
    {
        CriteriaBuilder builder=getEntityManager().getCriteriaBuilder();
        CriteriaDelete<Payments> delete= builder.createCriteriaDelete(Payments.class);
        Root<Payments>root=delete.from(Payments.class);
        delete.where(builder.equal(root.get("payment_id"),id));

        getEntityManager().createQuery(delete).executeUpdate();
    }

    public Payments GetPaymentByTicket(Long id)
    {
        CriteriaBuilder builder=getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Payments> query=builder.createQuery(Payments.class);
        Root<Payments>root=query.from(Payments.class);
        query.where(builder.equal(root.get("ticket_id"),id));

        return getEntityManager().createQuery(query).getSingleResult();
    }
}
