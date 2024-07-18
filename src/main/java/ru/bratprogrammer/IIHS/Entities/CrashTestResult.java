package ru.bratprogrammer.IIHS.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "crash_test_results")
public class CrashTestResult {

    @Id
    @Column(name = "crash_test_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int crashTestId;

    @Column(name = "car_id")
    private int carId;

    @Column(name = "small_overlap_front")
    private int smallOverlapFront;

    @Column(name = "moderate_overlap_front")
    private int moderateOverlapFront;

    @Column
    private int side;

    @Column
    private int headlights;

    @Column(name = "seat_belt_reminders")
    private int seatBeltReminders;

    @Column(name = "front_crash")
    private int frontCrash;

    @Column(name = "LATCH_ease_of_use")
    private int LatchEaseOfUse;

}
