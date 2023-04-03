package org.in.vehicle.controller;

import org.in.vehicle.model.CarAddRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicle")
public class VehicleDataController {

//	private final VehicleService vehicleService;
//
//    public VehicleDataController(VehicleService vehicleService) {
//        this.vehicleService = vehicleService;
//    }

    @PostMapping("/car/add")
    public ResponseEntity<?> addCar(@RequestBody CarAddRequest request){
        return null;
    }
}

