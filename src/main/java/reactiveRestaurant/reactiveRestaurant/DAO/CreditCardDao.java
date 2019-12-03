package reactiveRestaurant.reactiveRestaurant.DAO;

import reactiveRestaurant.reactiveRestaurant.entity.CreditCard;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;

public class CreditCardDao implements Dao<CreditCard> {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(CreditCard creditCard) {
        entityManager.persist(creditCard);
    }

    @Override
    public CreditCard findById(UUID id) {
        TypedQuery<CreditCard> query = entityManager.createQuery("SELECT x FROM Credit_card x WHERE x.id = :id",CreditCard.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public List<CreditCard> findAll() {
        Query query = entityManager.createQuery("SELECT x FROM Credit_card x ");
        return query.getResultList();
    }

    @Override
    public void update(CreditCard creditCard) {
        TypedQuery<CreditCard> query = entityManager.createQuery("UPDATE Credit_card x SET x.balance = :balance, x.bank = :bank WHERE x.id= :id",CreditCard.class);
        query.setParameter("balance",creditCard.getBalance());
        query.setParameter("bank",creditCard.getBank());
        query.setParameter("id",creditCard.getId());
        query.executeUpdate();
    }

    @Override
    public void remove(CreditCard creditCard) {
        TypedQuery<CreditCard> query = entityManager.createQuery("DELETE FROM Credit_card x WHERE x.id = :id",CreditCard.class);
        query.setParameter("id",creditCard.getId());
        query.executeUpdate();
    }

    @Override
    public void removeAll() {
        TypedQuery<CreditCard> query = entityManager.createQuery("DELETE FROM Credit_card",CreditCard.class);
        query.executeUpdate();
    }
}
