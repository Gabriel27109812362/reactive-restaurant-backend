package reactiveRestaurant.reactiveRestaurant.DAO;

import reactiveRestaurant.reactiveRestaurant.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;

public class UserDao implements Dao<User> {


    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public User findById(UUID id) {
        TypedQuery<User> query = entityManager.createQuery("SELECT x FROM User x WHERE x.id = :id", User.class);
        query.setParameter("id", id);
        return query.getSingleResult();

    }

    @Override
    public List<User> findAll() {
        Query query = entityManager.createQuery("SELECT x FROM User x ");
        return query.getResultList();

    }

    @Override
    public void update(User user) {
        TypedQuery<User> query = entityManager.createQuery("UPDATE User x SET x.name= :name, x.surname= :surname, x.phoneNumber = :phoneNumber, x.email = :email, x.creditCard= :creditCard, x.address = :address WHERE x.id= :id",User.class);
        query.setParameter("name",user.getName());
        query.setParameter("surname",user.getSurname());
        query.setParameter("phoneNumber",user.getPhoneNumber());
        query.setParameter("email",user.getEmail());
        query.setParameter("creditCard",user.getCreditCard());
        query.setParameter("address",user.getAddress());
        query.setParameter("id",user.getId());
        query.executeUpdate();
    }

    @Override
    public void remove(User user) {
        TypedQuery<User> query = entityManager.createQuery("DELETE FROM User x WHERE x.id = :id",User.class);
        query.setParameter("id",user.getId());
        query.executeUpdate();
    }

    @Override
    public void removeAll() {
        TypedQuery<User> query = entityManager.createQuery("DELETE FROM User",User.class);
        query.executeUpdate();
    }


}
