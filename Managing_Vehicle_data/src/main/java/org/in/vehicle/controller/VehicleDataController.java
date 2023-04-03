package org.in.vehicle.controller;

import org.in.vehicle.model.CarAddRequest;
import org.in.vehicle.service.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicle")
public class VehicleDataController {

	private final VehicleService vehicleService;

    public VehicleDataController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/cars")
    public ResponseEntity<?> addCar(@RequestBody CarAddRequest request){
    	 try {
             return ResponseEntity.status(HttpStatus.OK).body(vehicleService.saveCarDetails(request));
         }catch (Exception e){
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getLocalizedMessage());
         }
    }
    @GetMapping("/cars/{vehicleId}")
    public ResponseEntity<?> getCarDetails(@PathVariable("vehicleId") Integer vehicleId){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getCarDetailsById(vehicleId));
        }catch (InvalidRequestException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());
        }
    }
}
