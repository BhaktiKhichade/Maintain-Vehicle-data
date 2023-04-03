package org.in.vehicle.service.impl;

import org.in.vehicle.model.CarAddRequest;
import org.in.vehicle.repository.VehicleRepository;
import org.in.vehicle.service.VehicleService;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public CarAddRequest saveCarDetails(CarAddRequest request) {
        return vehicleRepository.save(request);
    }

	
}
