package org.in.vehicle.service.impl;

import org.in.vehicle.model.CarDetails;
import org.in.vehicle.repository.VehicleRepository;
import org.in.vehicle.service.exceptions.InvalidRequestException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.in.vehicle.mock.VehicleServiceMock.getAddCarDetailsRequest;
import static org.in.vehicle.mock.VehicleServiceMock.getCarDetails;
import static org.junit.jupiter.api.Assertions.assertTrue;

class VehicleServiceImplTest {

    @InjectMocks
    VehicleServiceImpl vehicleService;

    @Mock
    VehicleRepository vehicleRepository;
    
    private final Integer vehicleId = 7;
    
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
    @Test
    @DisplayName("Positive case: fetch car details by vehicle id")
    void getCarDetailsById() throws IOException {
        CarDetails expectedValue = getCarDetails();
        Mockito.when(vehicleRepository.findById(vehicleId)).thenReturn(Optional.ofNullable(getCarDetails()));
        CarDetails actualValue = vehicleService.getCarDetailsById(vehicleId);
        assertEquals(expectedValue,actualValue);
    }

    @Test
    @DisplayName("Negative case: fetch car details by vehicle id")
    void getCarDetailsByIdNegativeCase(){
        try {
            Mockito.when(vehicleRepository.findById(vehicleId))
                    .thenReturn(Optional.empty());
            vehicleService.getCarDetailsById(vehicleId);
        }catch (InvalidRequestException e){
            assertTrue(true);
        }
    }
}