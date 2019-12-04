package reactiveRestaurant.reactiveRestaurant.DAO;

import reactiveRestaurant.reactiveRestaurant.entity.Dish;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;

    public class DishDao implements Dao<Dish> {


        @PersistenceContext
        EntityManager entityManager;

        @Override
        public void save(Dish dish) {
            entityManager.persist(dish);
        }

        @Override
        public Dish findById(UUID id) {
            TypedQuery<Dish> query = entityManager.createQuery("SELECT x FROM Dish x WHERE x.id = :id", Dish.class);
            query.setParameter("id", id);
            return query.getSingleResult();

        }

        @Override
        public List<Dish> findAll() {
            Query query = entityManager.createQuery("SELECT x FROM Dish x ");
            return query.getResultList();

        }

        @Override
        public void update(Dish dish) {
            TypedQuery<Dish> query = entityManager.createQuery("UPDATE Dish x SET x.ingredients= :ingredients, x.price= :price WHERE x.id= :id", Dish.class);
            query.setParameter("ingredients", dish.getIngredients());
            query.setParameter("price", dish.getPrice());
            query.setParameter("id", dish.getId());
            query.executeUpdate();
        }

        @Override
        public void remove(Dish dish) {
            TypedQuery<Dish> query = entityManager.createQuery("DELETE FROM Dish x WHERE x.id = :id", Dish.class);
            query.setParameter("id", dish.getId());
            query.executeUpdate();
        }


        @Override
        public void removeAll() {
            TypedQuery<Dish> query = entityManager.createQuery("DELETE FROM Dish", Dish.class);
            query.executeUpdate();
        }


    }
}
