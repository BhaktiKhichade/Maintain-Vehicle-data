package org.in.vehicle.mock;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;


import java.io.File;
import java.io.IOException;

import org.in.vehicle.model.CarDetails;

public class VehicleServiceMock {
    ObjectMapper objectMapper = getObjectMapper();
    public static CarDetails getCarDetails() throws IOException {
        ObjectMapper objectMapper = getObjectMapper();
        CarDetails carDetails = objectMapper
                .readValue(new File("src/test/java/org/in/vehicle/resource/CarDetails.json"), CarDetails.class);
        return carDetails;
    }
    public static CarDetails getAddCarDetailsRequest() throws IOException {
        ObjectMapper objectMapper = getObjectMapper();
        CarDetails carDetails = objectMapper
                .readValue(new File("src/test/java/org/in/vehicle/resource/AddCarDetailsRequest.json"), CarDetails.class);
        return carDetails;
    }

    public static ObjectMapper getObjectMapper(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;
    }
}
