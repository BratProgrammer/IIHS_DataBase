package ru.bratprogrammer.IIHS.Controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/iihs/cars")
@Validated
public class CarController {

}