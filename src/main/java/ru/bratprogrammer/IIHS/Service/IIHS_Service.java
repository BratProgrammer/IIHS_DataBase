package ru.bratprogrammer.IIHS.Service;

import ru.bratprogrammer.IIHS.Entities.Car;
import ru.bratprogrammer.IIHS.Entities.CrashTestResult;

import java.util.List;

public interface IIHS_Service {

    void createCar(Car car);
    void updateCar(int id, Car car);
    Car findCarById(int id);
    void deleteCarById(int id);
    void deleteCar(Car car);
    void createCrashTestResult(CrashTestResult crashTestResult);
    void updateCrashTestResult(int id, CrashTestResult crashTestResult);
    CrashTestResult findCrashTestResultById(int id);
    void deleteCrashTestResultById(int id);
    void deleteCrashTestResult(CrashTestResult crashTestResult);
    Car getBestCarByAverageOfTestsResults(int[] idArray);
    List<Car> getAllCars();

    Integer getCarId(Car car);
}
