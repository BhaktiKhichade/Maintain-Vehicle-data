package org.in.vehicle.service;

import org.in.vehicle.model.CarDetails;

public interface VehicleService {
    CarDetails saveCarDetails(CarDetails request);
    
    CarDetails getCarDetailsById(Integer vehicleId);
    
    void deleteCarDetailsById(Integer vehicleId);
}
