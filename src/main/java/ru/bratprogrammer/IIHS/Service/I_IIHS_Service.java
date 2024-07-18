package ru.bratprogrammer.IIHS.Service;

import ru.bratprogrammer.IIHS.Entities.Car;
import ru.bratprogrammer.IIHS.Entities.CrashTestResult;

public interface I_IIHS_Service {

    public void createCar(Car car);
    public void updateCar(Car car);
    public Car findCarById(int id);
    public void deleteCarById(int id);
    public void deleteCar(Car car);
    public void createCrashTestResult(CrashTestResult crashTestResult);
    public void updateCrashTestResult(CrashTestResult crashTestResult);
    public CrashTestResult findCrashTestResultById(int id);
    public void deleteCrashTestResultById(int id);
    public void deleteCrashTestResult(CrashTestResult crashTestResult);


}
