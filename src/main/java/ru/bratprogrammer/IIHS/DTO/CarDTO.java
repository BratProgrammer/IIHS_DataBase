package ru.bratprogrammer.IIHS.DTO;

import lombok.Data;

@Data
public class CarDTO {

    private int carId;

    private String model;

    private String brand;

    private String carType;

    private int yearOfCreate;

}
