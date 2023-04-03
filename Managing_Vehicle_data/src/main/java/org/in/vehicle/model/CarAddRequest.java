package org.in.vehicle.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@EntityScan
@Table(name = "vehicle_data")
public class CarAddRequest {
    @Id
    @Column(name = "vehicle_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer vehicleId;
    @Column(name = "condition")
    private String condition;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "details_id")
    private Details details;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    private Location location;

}
