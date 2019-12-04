package reactiveRestaurant.reactiveRestaurant.DAO;

import reactiveRestaurant.reactiveRestaurant.entity.Order;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;

public class OrderDao implements Dao<Order> {


    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(Order order) {
        entityManager.persist(order);
    }

    @Override
    public Order findById(UUID id) {
        TypedQuery<Order> query = entityManager.createQuery("SELECT x FROM Order x WHERE x.id = :id", Order.class);
        query.setParameter("id", id);
        return query.getSingleResult();

    }

    @Override
    public List<Order> findAll() {
        Query query = entityManager.createQuery("SELECT x FROM Order x ");
        return query.getResultList();

    }

    @Override
    public void update(Order order) {
        TypedQuery<Order> query = entityManager.createQuery("UPDATE Order x SET x.state= :state, x.dishes= :dishes, x.totalCost= :totalCost, x.accept_date= :accept_date, x.finish_date= :finish_date WHERE x.id= :id", Order.class);
        query.setParameter("state", order.getState());
        query.setParameter("dishes",order.getDishes());
        query.setParameter("totalCost",order.getTotalCost());
        query.setParameter("accept_date",order.getAccept_date());
        query.setParameter("finish_date",order.getFinish_date());
        query.setParameter("id", order.getId());
        query.executeUpdate();
    }

    @Override
    public void remove(Order order) {
        TypedQuery<Order> query = entityManager.createQuery("DELETE FROM Order x WHERE x.id = :id", Order.class);
        query.setParameter("id", order.getId());
        query.executeUpdate();
    }


    @Override
    public void removeAll() {
        TypedQuery<Order> query = entityManager.createQuery("DELETE FROM Order", Order.class);
        query.executeUpdate();
    }


}
