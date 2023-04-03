package org.in.vehicle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@EntityScan({"org.in.vehicle.model"})
public class ManagingVehicleDataApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(ManagingVehicleDataApplication.class, args);
	}

}
