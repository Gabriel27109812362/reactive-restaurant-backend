package reactiveRestaurant.reactiveRestaurant.DAO;

import java.util.List;
import java.util.UUID;

public interface Dao<T> {
    List<T> getAll();
    List<T> findT ();

    void save (T t);
    void update (T t, String[] params);
    void remove(T t);
    void add(T t);
    void findById(UUID id);
    void swap(T t,T t2);


}
