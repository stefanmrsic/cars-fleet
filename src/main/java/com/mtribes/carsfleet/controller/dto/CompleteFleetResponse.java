package com.mtribes.carsfleet.controller.dto;

import org.immutables.value.Value;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Value.Immutable
public interface CompleteFleetResponse {
    @NotNull
    @NotEmpty
    List<SingleVehicleResponse> getListOfCars();


}
