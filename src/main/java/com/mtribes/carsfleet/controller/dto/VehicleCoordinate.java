package com.mtribes.carsfleet.controller.dto;

import org.immutables.value.Value;

import javax.validation.constraints.NotEmpty;

@Value.Immutable
public interface VehicleCoordinate {
    @NotEmpty
    double getLatitude();
    @NotEmpty
    double getLongitude();
    @NotEmpty
    double getAltitude();

}
