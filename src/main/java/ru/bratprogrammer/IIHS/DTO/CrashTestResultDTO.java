package ru.bratprogrammer.IIHS.DTO;

import lombok.Data;
@Data
public class CrashTestResultDTO {

    private int crashTestId;

    private int carId;

    private int smallOverlapFront;

    private int moderateOverlapFront;

    private int side;

    private int headlights;

    private int seatBeltReminders;

    private int frontCrash;

    private int LatchEaseOfUse;
}
