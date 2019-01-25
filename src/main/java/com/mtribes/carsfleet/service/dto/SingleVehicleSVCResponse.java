package com.mtribes.carsfleet.service.dto;

import com.mtribes.carsfleet.controller.dto.VehicleCoordinate;
import org.immutables.value.Value;

@Value.Immutable
public interface SingleVehicleSVCResponse {
    String getAddress();
    VehicleCoordinate getCoordinates();
    String getEngineType();
    String getExterior();
    int getFuel();
    String getInterior();
    String getName();
    String getVin();
}
