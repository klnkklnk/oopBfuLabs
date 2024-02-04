package bfu.oop.lab5;


public interface IRepository<T> {
    void add(T item);
    void remove(T item);
    void update(T item);
}
