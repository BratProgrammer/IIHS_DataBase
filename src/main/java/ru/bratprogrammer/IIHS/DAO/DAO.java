package ru.bratprogrammer.IIHS.DAO;

import org.springframework.transaction.annotation.Transactional;
import ru.bratprogrammer.IIHS.Entities.Car;

import java.util.List;

public interface DAO<T> {
    public void create(T t);
    public void update(int id, T t);
    public T getById(int id);
    public List<T> getAll();
    public void delete(T t);
    public void deleteById(int id);
}
