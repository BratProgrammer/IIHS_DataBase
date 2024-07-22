package ru.bratprogrammer.IIHS.DAO;

import ru.bratprogrammer.IIHS.Entities.Car;

public interface CarDAO extends DAO<Car> {
    Integer getCarId(Car car);

}
