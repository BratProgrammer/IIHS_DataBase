package ru.bratprogrammer.IIHS.DAO;

import java.util.List;

public interface DAO<T> {
    public void create(T t);
    public void update(T t);
    public T getById(int id);
    public List<T> getAll();
    public void delete(T t);
    public void deleteById(int id);
}
