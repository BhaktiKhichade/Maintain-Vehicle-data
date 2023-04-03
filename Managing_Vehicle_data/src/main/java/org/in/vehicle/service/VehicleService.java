package org.in.vehicle.service;

import org.in.vehicle.model.CarAddRequest;

public interface VehicleService {
    CarAddRequest saveCarDetails(CarAddRequest request);
}
