package ru.bratprogrammer.IIHS.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.bratprogrammer.IIHS.Entities.Car;
import ru.bratprogrammer.IIHS.Entities.CrashTestResult;
import ru.bratprogrammer.IIHS.Service.I_IIHS_Service;

@RestController
@RequestMapping("api/v1/iihs")
@Validated
public class Controller {

    @Autowired
    I_IIHS_Service service;


    @GetMapping("get_best_car")
    public ResponseEntity<Car> getBestCar(@RequestBody int[] idArray) {
        return ResponseEntity.ok(service.getBestCarByAverageOfTestsResults(idArray));
    }


    @PostMapping("/create_car")
    public ResponseEntity createCar(@RequestBody Car car) {
        service.createCar(car);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/create_crash_test_result")
    public ResponseEntity createCrashTestResult(@RequestBody CrashTestResult crashTestResult) {
        service.createCrashTestResult(crashTestResult);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get_car_by_id/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable("id") int id) {
        return ResponseEntity.ok(service.findCarById(id));
    }

    @DeleteMapping("/delete_car_by_id/{id}")
    public ResponseEntity deleteCar(@PathVariable("id") int id) {
        service.deleteCarById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update_car")
    public ResponseEntity deleteCar(@RequestBody Car car) {
        service.updateCar(car);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get_crash_test_result_by_id/{id}")
    public ResponseEntity<CrashTestResult> getCrashTestResultById(@PathVariable("id") int id) {
        return ResponseEntity.ok(service.findCrashTestResultById(id));
    }

    @DeleteMapping("/delete_crash_test_result_by_id/{id}")
    public ResponseEntity deleteCrashTestResult(@PathVariable("id") int id) {
        service.deleteCrashTestResultById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update_crash_test_result")
    public ResponseEntity deleteCrashTestResult(@RequestBody CrashTestResult crashTestResult) {
        service.updateCrashTestResult(crashTestResult);
        return ResponseEntity.ok().build();
    }
}