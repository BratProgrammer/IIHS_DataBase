package ru.bratprogrammer.IIHS.DAO;

import java.util.List;

public interface DAO<T> {
    void create(T t);
    void update(int id, T t);
    T getById(int id);
    List<T> getAll();
    void delete(T t);
    void deleteById(int id);
}
