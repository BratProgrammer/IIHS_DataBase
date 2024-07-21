package ru.bratprogrammer.IIHS.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "cars")
public class Car {

    @Id
    @Column(name = "car_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int carId;

    @Column
    private String model;

    @Column
    private String brand;

    @Column(name = "car_type")
    private String carType;

    @Column(name = "year_of_create")
    private int yearOfCreate;

}
