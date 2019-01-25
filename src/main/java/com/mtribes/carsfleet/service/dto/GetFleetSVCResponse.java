package com.mtribes.carsfleet.service.dto;

import com.mtribes.carsfleet.controller.dto.SingleVehicleResponse;
import org.immutables.value.Value;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Value.Immutable
public interface GetFleetSVCResponse {
    @NotNull
    @NotEmpty
    List<SingleVehicleSVCResponse> getListOfVehicles();

}
