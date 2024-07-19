package ru.bratprogrammer.IIHS.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bratprogrammer.IIHS.DAO.CarDAO;
import ru.bratprogrammer.IIHS.DAO.CrashTestResultDAO;
import ru.bratprogrammer.IIHS.Entities.Car;
import ru.bratprogrammer.IIHS.Entities.CrashTestResult;
import java.util.Optional;

@Service
public class IIHS_Service implements I_IIHS_Service {

    @Autowired
    private CarDAO carDAO;

    @Autowired
    private CrashTestResultDAO crashTestResultDAO;

    @Override
    @Transactional
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

    @Override
    @Transactional
    public void createCar(Car car) {
        carDAO.create(car);
    }

    @Override
    @Transactional
    public void updateCar(Car car) {
        carDAO.update(car);
    }

    @Override
    @Transactional
    public Car findCarById(int id) {
        return carDAO.getById(id);
    }

    @Override
    @Transactional
    public void deleteCarById(int id) {
        carDAO.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteCar(Car car) {
        carDAO.delete(car);
    }

    @Override
    @Transactional
    public void createCrashTestResult(CrashTestResult crashTestResult) {
        crashTestResultDAO.create(crashTestResult);
    }

    @Override
    @Transactional
    public void updateCrashTestResult(CrashTestResult crashTestResult) {
        crashTestResultDAO.update(crashTestResult);
    }

    @Override
    @Transactional
    public CrashTestResult findCrashTestResultById(int id) {
        return crashTestResultDAO.getById(id);
    }

    @Override
    @Transactional
    public void deleteCrashTestResultById(int id) {
        crashTestResultDAO.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteCrashTestResult(CrashTestResult crashTestResult) {
        crashTestResultDAO.delete(crashTestResult);
    }
}