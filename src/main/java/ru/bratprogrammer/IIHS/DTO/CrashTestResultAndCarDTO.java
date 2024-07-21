package ru.bratprogrammer.IIHS.DTO;

import lombok.Data;

@Data
public class CrashTestResultAndCarDTO {
    private CarDTO car;
    private CrashTestResultDTO crashTestResult;
}
