package reactiveRestaurant.reactiveRestaurant.DAO;

import reactiveRestaurant.reactiveRestaurant.entity.Address;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;

public class AddressDao implements Dao<Address> {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(Address address) {
        entityManager.persist(address);
    }

    @Override
    public Address findById(UUID id) {
        TypedQuery<Address> query = entityManager.createQuery("SELECT x FROM Address x WHERE x.id = :id",Address.class);
        query.setParameter("id", id);
        return query.getSingleResult();

    }

    @Override
    public List<Address> findAll() {
        Query query = entityManager.createQuery("SELECT x FROM Address x ");
        return query.getResultList();

    }

    @Override
    public void update(Address address) {
        TypedQuery<Address> query = entityManager.createQuery("UPDATE Address x SET x.street = :street, x.house_number = :house_number, x.city = :city, x.postcode = postcode WHERE x.id= :id",Address.class);
        query.setParameter("street",address.getStreet());
        query.setParameter("house_number",address.getHouse_number());
        query.setParameter("city",address.getCity());
        query.setParameter("postcode",address.getPostcode());
        query.setParameter("id",address.getId());
        query.executeUpdate();
    }

    @Override
    public void remove(Address address) {
        TypedQuery<Address> query = entityManager.createQuery("DELETE FROM Address x WHERE x.id = :id",Address.class);
        query.setParameter("id",address.getId());
        query.executeUpdate();
    }

    @Override
    public void removeAll() {
        TypedQuery<Address> query = entityManager.createQuery("DELETE FROM Address",Address.class);
        query.executeUpdate();
    }
}
