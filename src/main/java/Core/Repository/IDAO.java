package Core.Repository;


import java.util.List;
import java.util.Optional;

public interface IDAO<T> {
    List<T> getAll();
    void  update(T item);
    void  remove(T item);
    void  create(T item);
}
