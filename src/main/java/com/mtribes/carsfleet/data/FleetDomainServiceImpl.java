package com.mtribes.carsfleet.data;

import com.mtribes.carsfleet.domain.FleetDomainService;
import com.mtribes.carsfleet.domain.dto.CoordinatesModel;
import com.mtribes.carsfleet.domain.dto.SingleVehicleModel;
import com.mtribes.carsfleet.repo.VehicleRepository;
import com.mtribes.carsfleet.repo.entities.CoordinatesEntity;
import com.mtribes.carsfleet.repo.entities.VehicleEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FleetDomainServiceImpl implements FleetDomainService {

    private VehicleRepository vehicleRepository;

    public FleetDomainServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<SingleVehicleModel> getListOfAllVehicles() {
        return buildListOfAllVehicles(vehicleRepository.findAll());
    }

    private List<SingleVehicleModel> buildListOfAllVehicles(List<VehicleEntity> allVehicles) {
        return allVehicles.stream().map(this::buildSingleVehicleModelFromEntity).collect(Collectors.toList());
    }

    private SingleVehicleModel buildSingleVehicleModelFromEntity(VehicleEntity vehicleEntity) {
        return new SingleVehicleModel.Builder()
                .withAddress(vehicleEntity.getAddress())
                .withCoordinates(buildCoordinatesModelFromEntity(vehicleEntity.getCoordinates()))
                .withEngineType(vehicleEntity.getEngineType())
                .withExterior(vehicleEntity.getExterior())
                .withFuel(vehicleEntity.getFuel())
                .withInterior(vehicleEntity.getInterior())
                .withName(vehicleEntity.getName())
                .withVin(vehicleEntity.getVin())
                .build();

    }

    private CoordinatesModel buildCoordinatesModelFromEntity(CoordinatesEntity coordinates) {
        return new CoordinatesModel.Builder()
                .withAltitude(coordinates.getAltitude())
                .withLatitude(coordinates.getLatitude())
                .withLongitude(coordinates.getLongitude())
                .build();
    }
}
