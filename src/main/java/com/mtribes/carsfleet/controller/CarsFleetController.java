package com.mtribes.carsfleet.controller;


import com.mtribes.carsfleet.controller.dto.*;
import com.mtribes.carsfleet.controller.dto.ImmutableCompleteFleetResponse;
import com.mtribes.carsfleet.controller.dto.ImmutableSingleVehicleResponse;
import com.mtribes.carsfleet.controller.dto.ImmutableVehicleCoordinate;
import com.mtribes.carsfleet.service.FleetService;
import com.mtribes.carsfleet.service.dto.GetFleetSVCResponse;
import com.mtribes.carsfleet.service.dto.SingleVehicleSVCResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@Controller
public class CarsFleetController {

    private FleetService fleetService;

    public CarsFleetController(FleetService fleetService) {
        this.fleetService = fleetService;
    }

    @RequestMapping("/fleet")
    public @ResponseBody
    CompleteFleetResponse getCompleeteFleet() {
        return buildCompleteFleetResponseFromCompleteFleetSvcResponse(
                fleetService.getCompleteFleet());
    }

    private CompleteFleetResponse buildCompleteFleetResponseFromCompleteFleetSvcResponse(final GetFleetSVCResponse completeFleet) {
        return ImmutableCompleteFleetResponse.builder()
                .addAllListOfCars(completeFleet.getListOfVehicles()
                        .stream()
                        .map(this::buildSingleFleetVehicleResponse)
                        .collect(Collectors.toList()))
                .build();
    }

    private SingleVehicleResponse buildSingleFleetVehicleResponse(final SingleVehicleSVCResponse singleVehicleSVCResponse) {
        return ImmutableSingleVehicleResponse
                .builder()
                .address(singleVehicleSVCResponse.getAddress())
                .engineType(singleVehicleSVCResponse.getEngineType())
                .exterior(singleVehicleSVCResponse.getExterior())
                .fuel(singleVehicleSVCResponse.getFuel())
                .interior(singleVehicleSVCResponse.getInterior())
                .name(singleVehicleSVCResponse.getName())
                .vin(singleVehicleSVCResponse.getVin())
                .coordinates(buildSingleFleetVehicleCoordinates(singleVehicleSVCResponse.getCoordinates()))
                .build();
    }

    private VehicleCoordinate buildSingleFleetVehicleCoordinates(final VehicleCoordinate coordinates) {
        return ImmutableVehicleCoordinate
                .builder()
                .latitude(coordinates.getLatitude())
                .longitude(coordinates.getLongitude())
                .altitude(coordinates.getAltitude())
                .build();
    }

}
