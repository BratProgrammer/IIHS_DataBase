package ru.bratprogrammer.IIHS.DTO;

import lombok.Data;
import ru.bratprogrammer.IIHS.Entities.Car;
import ru.bratprogrammer.IIHS.Entities.CrashTestResult;

@Data
public class CrashTestResultWithCarDTO {
    private CarDTO carDTO;
    private CrashTestResultDTO crashTestResultDTO;

    public CrashTestResult toEntity() {
        CrashTestResult crashTestResult = new CrashTestResult();

        crashTestResult.setCrashTestId(crashTestResultDTO.getCrashTestId());
        crashTestResult.setCar(carDTO.toEntity());
        crashTestResult.setSmallOverlapFront(crashTestResultDTO.getSmallOverlapFront());
        crashTestResult.setModerateOverlapFront(crashTestResultDTO.getModerateOverlapFront());
        crashTestResult.setSide(crashTestResultDTO.getSide());
        crashTestResult.setHeadlights(crashTestResultDTO.getHeadlights());
        crashTestResult.setSeatBeltReminders(crashTestResultDTO.getSeatBeltReminders());
        crashTestResult.setFrontCrash(crashTestResultDTO.getFrontCrash());
        crashTestResult.setLatchEaseOfUse(crashTestResultDTO.getLatchEaseOfUse());

        return crashTestResult;
    }

}
