package org.in.vehicle.service.impl;

import org.in.vehicle.model.CarDetails;
import org.in.vehicle.repository.VehicleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.in.vehicle.mock.VehicleServiceMock.getAddCarDetailsRequest;
import static org.in.vehicle.mock.VehicleServiceMock.getCarDetails;

class VehicleServiceImplTest {

    @InjectMocks
    VehicleServiceImpl vehicleService;

    @Mock
    VehicleRepository vehicleRepository;
    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Positive case: save car details")
    void saveCarDetails() throws IOException {
        CarDetails request = getAddCarDetailsRequest();
        CarDetails carDetails = getCarDetails();
        Mockito.when(vehicleRepository.save(request)).thenReturn(carDetails);
        CarDetails actualValue = vehicleService.saveCarDetails(request);
        assertEquals(carDetails, actualValue);
    }
}