package ru.bratprogrammer.IIHS.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.bratprogrammer.IIHS.DTO.CarDTO;
import ru.bratprogrammer.IIHS.DTO.CrashTestResultDTO;
import ru.bratprogrammer.IIHS.Entities.Car;
import ru.bratprogrammer.IIHS.Service.I_IIHS_Service;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/iihs")
@Validated
public class Controller {

    @Autowired
    I_IIHS_Service service;


    @GetMapping("get_best_car")
    public ResponseEntity<CarDTO> getBestCar(@RequestBody int[] idArray) {
        return ResponseEntity.ok(new CarDTO().from(service.getBestCarByAverageOfTestsResults(idArray)));
    }


    @PostMapping("/create_car")
    public ResponseEntity createCar(@RequestBody CarDTO car) {
        service.createCar(car.toEntity());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/create_crash_test_result")
    public ResponseEntity createCrashTestResult(@RequestBody CrashTestResultDTO crashTestResult) {
        service.createCrashTestResult(crashTestResult.toEntity());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get_car_by_id/{id}")
    public ResponseEntity<CarDTO> getCarById(@PathVariable("id") int id) {
        return ResponseEntity.ok(new CarDTO().from(service.findCarById(id)));
    }

    @DeleteMapping("/delete_car_by_id/{id}")
    public ResponseEntity deleteCar(@PathVariable("id") int id) {
        service.deleteCarById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update_car/{id}")
    public ResponseEntity deleteCar(@PathVariable("id") int id, @RequestBody CarDTO car) {
        service.updateCar(id, car.toEntity());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get_crash_test_result_by_id/{id}")
    public ResponseEntity<CrashTestResultDTO> getCrashTestResultById(@PathVariable("id") int id) {
        return ResponseEntity.ok(new CrashTestResultDTO().from(service.findCrashTestResultById(id)));
    }

    @DeleteMapping("/delete_crash_test_result_by_id/{id}")
    public ResponseEntity deleteCrashTestResult(@PathVariable("id") int id) {
        service.deleteCrashTestResultById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update_crash_test_result/{id}")
    public ResponseEntity updateCrashTestResult(@PathVariable("id") int id, @RequestBody CrashTestResultDTO crashTestResult) {
        service.updateCrashTestResult(id, crashTestResult.toEntity());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get_all_cars")
    public ResponseEntity<List<CarDTO>> getAllCar() {
        List<Car> list = service.getAllCars();
        List<CarDTO> listDTO = new ArrayList<>();

        for (Car car : list) {
            listDTO.add(new CarDTO().from(car));
        }

        return ResponseEntity.ok(listDTO);
    }

    @GetMapping("/get_car_id")
    public ResponseEntity<Integer> getCarId(@RequestBody CarDTO carDTO) {
        return ResponseEntity.ok(service.getCarId(carDTO.toEntity()));
    }
}