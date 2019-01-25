package com.mtribes.carsfleet.controller.dto;

import org.immutables.value.Value;

@Value.Immutable
public interface SingleVehicleResponse {
    String getAddress();
    VehicleCoordinate getCoordinates();
    String getEngineType();
    String getExterior();
    int getFuel();
    String getInterior();
    String getName();
    String getVin();
}
