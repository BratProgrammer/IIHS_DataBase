package ru.bratprogrammer.IIHS.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bratprogrammer.IIHS.DAO.CarDAO;
import ru.bratprogrammer.IIHS.DAO.CrashTestResultDAO;
import ru.bratprogrammer.IIHS.Entities.Car;
import ru.bratprogrammer.IIHS.Entities.CrashTestResult;

import java.util.List;
import java.util.Optional;

@Service
public class IIHS_ServiceImpl implements IIHS_Service {

    @Autowired
    private CarDAO carDAO;

    @Autowired
    private CrashTestResultDAO crashTestResultDAO;

    @Override
    public Car getBestCarByAverageOfTestsResults(int[] idArray) {
        Car resultCar;
        int carId = -1;
        double maxAverage = 0;
        Optional<Double> currentAverage;

        for (int id: idArray) {
            currentAverage = crashTestResultDAO.getAverageTestResultByCarId(id);
            if (currentAverage.isPresent()) {
                if (maxAverage < currentAverage.get()) {
                    carId = id;
                    maxAverage = currentAverage.get();
                }
            }
        }

        if (carId == -1) {
            return null;
        }

        resultCar = carDAO.getById(carId);
        return resultCar;
    }

    public List<Car> getAllCars() {
        return carDAO.getAll();
    }

    @Override
    public Integer getCarId(Car car) {
        return carDAO.getCarId(car);
    }

    @Override
    public void createCar(Car car) {
        carDAO.create(car);
    }

    @Override
    public void updateCar(int id, Car car) {
        carDAO.update(id, car);
    }

    @Override
    public Car findCarById(int id) {
        return carDAO.getById(id);
    }

    @Override
    public void deleteCarById(int id) {
        carDAO.deleteById(id);
    }

    @Override
    public void deleteCar(Car car) {
        carDAO.delete(car);
    }

    @Override
    public void createCrashTestResult(CrashTestResult crashTestResult) {
        crashTestResultDAO.create(crashTestResult);
    }

    @Override
    public void updateCrashTestResult(int id, CrashTestResult crashTestResult) {
        crashTestResultDAO.update(id, crashTestResult);
    }

    @Override
    public CrashTestResult findCrashTestResultById(int id) {
        return crashTestResultDAO.getById(id);
    }

    @Override
    public void deleteCrashTestResultById(int id) {
        crashTestResultDAO.deleteById(id);
    }

    @Override
    public void deleteCrashTestResult(CrashTestResult crashTestResult) {
        crashTestResultDAO.delete(crashTestResult);
    }
}