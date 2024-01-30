package bfu.oop.lab5;

import java.util.List;

public interface IRepository<T> {
    List<T> getAll();
    void add(T item);
    void remove(T item);
    void update(T item);
}
