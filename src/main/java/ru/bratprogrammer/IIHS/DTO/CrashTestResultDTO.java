package ru.bratprogrammer.IIHS.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import ru.bratprogrammer.IIHS.Entities.CrashTestResult;
import ru.bratprogrammer.IIHS.Service.I_IIHS_Service;

@Data
public class CrashTestResultDTO {

    @Autowired
    @JsonIgnore
    I_IIHS_Service service;

    private int crashTestId;

    private int carId;

    private int smallOverlapFront;

    private int moderateOverlapFront;

    private int side;

    private int headlights;

    private int seatBeltReminders;

    private int frontCrash;

    private int LatchEaseOfUse;

    public CrashTestResultDTO from(CrashTestResult crashTestResult) {
        CrashTestResultDTO crashTestResultDTO = new CrashTestResultDTO();
        crashTestResultDTO.setCrashTestId(crashTestResult.getCrashTestId());
        crashTestResultDTO.setCarId(crashTestResult.getCar().getCarId());
        crashTestResultDTO.setSmallOverlapFront(crashTestResult.getSmallOverlapFront());
        crashTestResultDTO.setModerateOverlapFront(crashTestResult.getModerateOverlapFront());
        crashTestResultDTO.setSide(crashTestResult.getSide());
        crashTestResultDTO.setHeadlights(crashTestResult.getHeadlights());
        crashTestResultDTO.setSeatBeltReminders(crashTestResult.getSeatBeltReminders());
        crashTestResultDTO.setFrontCrash(crashTestResult.getFrontCrash());
        crashTestResultDTO.setLatchEaseOfUse(crashTestResult.getLatchEaseOfUse());

        return crashTestResultDTO;
    }

    public CrashTestResult toEntity() {
        CrashTestResult crashTestResult = new CrashTestResult();
        crashTestResult.setCrashTestId(this.getCrashTestId());
        crashTestResult.setCar(service.findCarById(this.getCarId()));
        crashTestResult.setSmallOverlapFront(this.getSmallOverlapFront());
        crashTestResult.setModerateOverlapFront(this.getModerateOverlapFront());
        crashTestResult.setSide(this.getSide());
        crashTestResult.setHeadlights(this.getHeadlights());
        crashTestResult.setSeatBeltReminders(this.getSeatBeltReminders());
        crashTestResult.setFrontCrash(this.getFrontCrash());
        crashTestResult.setLatchEaseOfUse(this.getLatchEaseOfUse());

        return crashTestResult;
    }
}
