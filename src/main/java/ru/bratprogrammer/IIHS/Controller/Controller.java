package ru.bratprogrammer.IIHS.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.bratprogrammer.IIHS.Entities.Car;

@RestController
@RequestMapping("api/v1/iihs")
@Validated
public class Controller {

    @PostMapping("/create_car")
    public ResponseEntity createCar(@RequestBody Car car) {



        return ResponseEntity.ok().build();
    }

}
