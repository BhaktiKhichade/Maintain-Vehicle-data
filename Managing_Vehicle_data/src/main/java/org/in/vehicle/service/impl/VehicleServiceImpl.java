package org.in.vehicle.service.impl;

import java.util.Optional;

import org.in.vehicle.model.CarDetails;
import org.in.vehicle.repository.VehicleRepository;
import org.in.vehicle.service.VehicleService;
import org.in.vehicle.service.exceptions.InvalidRequestException;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService {
	
    private final VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public CarDetails saveCarDetails(CarDetails request) {
        return vehicleRepository.save(request);
    }
    
    @Override
    public CarDetails getCarDetailsById(Integer vehicleId) {
         return Optional.of(vehicleRepository.findById(vehicleId)).get().orElseThrow(() -> new InvalidRequestException("Unable to find vehicle of vehicle id :" + vehicleId));
    }	
    
    @Override
    public void deleteCarDetailsById(Integer vehicleId) {
            this.vehicleRepository.deleteById(vehicleId);
    }
}
