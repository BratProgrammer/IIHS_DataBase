package ru.bratprogrammer.IIHS.DAO;

import ru.bratprogrammer.IIHS.Entities.CrashTestResult;

import java.util.Optional;

public interface CrashTestResultDAO extends DAO<CrashTestResult> {
    Optional<Double> getAverageTestResultByCarId(int id);
}
