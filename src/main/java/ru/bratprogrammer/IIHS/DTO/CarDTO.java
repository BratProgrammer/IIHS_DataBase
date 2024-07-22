package ru.bratprogrammer.IIHS.DTO;

import lombok.Data;
import ru.bratprogrammer.IIHS.Entities.Car;

@Data
public class CarDTO {

    private int carId;

    private String model;

    private String brand;

    private String carType;

    private int yearOfCreate;

    public CarDTO from(Car car) {
        CarDTO carDTO = new CarDTO();

        carDTO.setCarId(car.getCarId());
        carDTO.setCarType(car.getCarType());
        carDTO.setBrand(car.getBrand());
        carDTO.setModel(car.getModel());
        carDTO.setYearOfCreate(car.getYearOfCreate());

        return carDTO;
    }

    public Car toEntity() {
        Car car = new Car();

        car.setCarId(this.getCarId());
        car.setCarType(this.getCarType());
        car.setBrand(this.getBrand());
        car.setModel(this.getModel());
        car.setYearOfCreate(this.getYearOfCreate());

        return car;
    }
}
