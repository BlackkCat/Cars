package com.blackcat.cars.controllers;

import com.blackcat.cars.models.Car;
import com.blackcat.cars.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarsController {
    private CarService service;

    @Autowired
    public CarsController(CarService carService){
        setCarService(carService);
    }

    @PostMapping("/new")
    public void createCar(@RequestBody Car car){
        service.createCar(car);
    }

    @GetMapping
    public List<Car> getAllCars(){
        return service.getAllCars();
    }

    public CarService getService() {
        return service;
    }

    public void setCarService(CarService service) {
        this.service = service;
    }
}
