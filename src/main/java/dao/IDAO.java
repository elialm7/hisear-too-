package dao;


import java.util.List;

public interface IDAO<T> {
    List<T> getAll();
    void  update(T item);
    void  remove(T item);
    void  create(T item);
}
