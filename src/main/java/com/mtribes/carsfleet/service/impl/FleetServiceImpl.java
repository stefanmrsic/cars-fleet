package com.mtribes.carsfleet.service.impl;

import com.mtribes.carsfleet.controller.dto.ImmutableVehicleCoordinate;
import com.mtribes.carsfleet.controller.dto.VehicleCoordinate;
import com.mtribes.carsfleet.domain.FleetDomainService;
import com.mtribes.carsfleet.domain.dto.CoordinatesModel;
import com.mtribes.carsfleet.domain.dto.SingleVehicleModel;
import com.mtribes.carsfleet.service.FleetService;
import com.mtribes.carsfleet.service.dto.GetFleetSVCResponse;
import com.mtribes.carsfleet.service.dto.ImmutableGetFleetSVCResponse;
import com.mtribes.carsfleet.service.dto.ImmutableSingleVehicleSVCResponse;
import com.mtribes.carsfleet.service.dto.SingleVehicleSVCResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FleetServiceImpl implements FleetService {

    private FleetDomainService fleetDomainService;

    public FleetServiceImpl(FleetDomainService fleetDomainService) {
        this.fleetDomainService = fleetDomainService;
    }

    @Override
    public GetFleetSVCResponse getCompleteFleet() {
        return buildGetFleetSVCResponse(fleetDomainService.getListOfAllVehicles());
    }

    private GetFleetSVCResponse buildGetFleetSVCResponse(List<SingleVehicleModel> listOfAllVehicles) {
        return ImmutableGetFleetSVCResponse.builder()
                .listOfVehicles(buildListOfFleetSVCVehicles(listOfAllVehicles))
                .build();
    }

    private List<SingleVehicleSVCResponse> buildListOfFleetSVCVehicles(List<SingleVehicleModel> listOfAllVehicles) {
        return listOfAllVehicles.stream()
                .map(this::buildSingleVehicleSVCResponse)
                .collect(Collectors.toList());
    }

    private SingleVehicleSVCResponse buildSingleVehicleSVCResponse(SingleVehicleModel singleVehicleModel) {
        return ImmutableSingleVehicleSVCResponse.builder()
                .address(singleVehicleModel.getAddress())
                .coordinates(buildSingleVehicleCoordinatesSVCResponse(singleVehicleModel.getCoordinates()))
                .engineType(singleVehicleModel.getEngineType())
                .exterior(singleVehicleModel.getExterior())
                .fuel(singleVehicleModel.getFuel())
                .interior(singleVehicleModel.getInterior())
                .name(singleVehicleModel.getName())
                .vin(singleVehicleModel.getVin())
                .build();
    }

    private VehicleCoordinate buildSingleVehicleCoordinatesSVCResponse(CoordinatesModel coordinates) {
        return ImmutableVehicleCoordinate.builder()
                .altitude(coordinates.getAlt())
                .latitude(coordinates.getLat())
                .longitude(coordinates.getLon())
                .build();
    }
}
