package reactiveRestaurant.reactiveRestaurant.DAO;

import reactiveRestaurant.reactiveRestaurant.entity.Ingredient;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import javax.persistence.*;


public class IngredientDao implements Dao<Ingredient> {

 @PersistenceContext
 EntityManager entityManager;

    @Override
    public void save (Ingredient t){
     entityManager.persist(t);
    }

    @Override
    public Ingredient findById(UUID id){
     TypedQuery<Ingredient> query = entityManager.createQuery("SELECT x FROM Ingredient x WHERE x.id = :id",Ingredient.class);
     query.setParameter("id", id);
    return query.getSingleResult();
    }

    @Override
    public List<Ingredient> findAll(){
        Query query = entityManager.createQuery("SELECT x FROM Ingredient x ");
     return query.getResultList();
    }

    @Override
    public void update (Ingredient t){

        TypedQuery<Ingredient> query = entityManager.createQuery("UPDATE Ingredient x SET x.name= :name WHERE x.id= :id",Ingredient.class);
        query.setParameter("name",t.getName());
        query.setParameter("id",t.getId());
       query.executeUpdate();
    }

    @Override
    public void remove(Ingredient t){
     TypedQuery<Ingredient> query = entityManager.createQuery("DELETE FROM Ingredient x WHERE x.id = :id",Ingredient.class);
     query.setParameter("id",t.getId());
     query.executeUpdate();
    }

    @Override
    public void removeAll(){
     TypedQuery<Ingredient> query = entityManager.createQuery("DELETE FROM Ingredient",Ingredient.class);
     query.executeUpdate();
    }

    /**
     * Zwraca obiekt z bazy na podstawie nazwy składnika
     *
     * @param name nazwa składnika
     * @return obiekt pobrany z bazy
     */
    public Ingredient findByName(String name){
     TypedQuery<Ingredient> query = entityManager.createQuery("SELECT x FROM Ingredient x WHERE x.name = :name",Ingredient.class);
     query.setParameter("name", name);
     return query.getSingleResult();
    }

}
