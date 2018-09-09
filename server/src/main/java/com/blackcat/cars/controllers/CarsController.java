package com.blackcat.cars.controllers;

import com.blackcat.cars.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cars")
public class CarsController {
    private CarService service;

    @Autowired
    public CarsController(CarService carService){
        setCarService(carService);
    }

    public CarService getService() {
        return service;
    }

    public void setCarService(CarService service) {
        this.service = service;
    }
}
