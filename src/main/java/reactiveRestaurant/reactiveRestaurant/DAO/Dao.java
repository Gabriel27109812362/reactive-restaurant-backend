package reactiveRestaurant.reactiveRestaurant.DAO;

import java.util.List;
import java.util.UUID;

/**
 * Bazowy interfejs DAO (Data Access Object, obiekt dostępu do danych),
 * określający sposób interakcji z bazą danych
 *
 * @param <T> klasa konkretnego komponentu, z którym pracujemy
 */
public interface Dao<T> {

    /**
     * Zapisuje obiekt do bazy
     * @param t obiekt, który ma zostać zapisany
     */
    void save (T t);

    /**
     * Zwraca obiekt z bazy na podstawie id
     *
     * @param id id obiektu
     * @return obiekt pobrany z bazy
     */
    T findById(UUID id);

    /**
     * Zwraca z bazy wszystkie obiekty z danej tabeli (encji)
     *
     * @return lista wszystkich obiektów z bazy
     */
    List<T> findAll();

    /**
     * Aktualizuje wartości obiektu w bazie
     *
     * @param t obiekt ze zaktualizowanymi wartościami
     */
    void update (T t);

    /**
     * Usuwa obiekt z bazy
     *
     * @param t obiekt to usunięcia
     */
    void remove(T t);

    /**
     * Usuwa z bazy wszystkie obiekty z danej tabeli (encji)
     */
    void removeAll();
}
