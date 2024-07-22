package ru.bratprogrammer.IIHS.DAO;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.bratprogrammer.IIHS.DTO.CarDTO;
import ru.bratprogrammer.IIHS.Entities.Car;

import java.util.List;

@Repository
public class CarDAO implements DAO<Car> {

    @Autowired
    EntityManager entityManager;

    @Override
    @Transactional
    public void create(Car car) {
        entityManager.persist(car);
    }

    @Override
    @Transactional
    public void update(int id, Car car) {
        Car carForUpdate = entityManager.find(Car.class, id);
        if (car != null && carForUpdate != null) {
            carForUpdate.setModel(car.getModel());
            carForUpdate.setCarType(car.getCarType());
            carForUpdate.setBrand(car.getBrand());
            carForUpdate.setYearOfCreate(car.getYearOfCreate());
            entityManager.merge(carForUpdate);
        }
    }

    @Override
    @Transactional
    public Car getById(int id) {
        Car car = entityManager.find(Car.class, id);
        entityManager.detach(car);
        return car;
    }

    @Override
    @Transactional
    public List<Car> getAll() {
        List<Car> list = entityManager.createQuery("SELECT car FROM Car car", Car.class).getResultList();
        list.forEach(entityManager::detach);
        return list;
    }

    @Override
    @Transactional
    public void delete(Car car) {
        if (car != null) {
            entityManager.remove(car);
        }
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Car carForDelete = entityManager.find(Car.class, id);
        if (carForDelete != null) {
            entityManager.remove(entityManager.find(Car.class, id));
        }
    }

    public Integer getCarId(Car car) {
        Integer id;
        String jpql = """
                SELECT car.id FROM Car car
                WHERE car.model = :model
                AND car.brand = :brand
                AND car.yearOfCreate = :yearOfCreate
                """;
        id = entityManager.createQuery(jpql, Integer.class)
                .setParameter("model", car.getModel())
                .setParameter("brand", car.getBrand())
                .setParameter("yearOfCreate", car.getYearOfCreate())
                .getFirstResult();
        return id;
    }

    /*
    * private void executeInsideTransaction(Consumer<EntityManager> action) {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            action.accept(entityManager);
            tx.commit();
        }
        catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
    }*/

}
