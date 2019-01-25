package com.mtribes.carsfleet.domain;

import com.mtribes.carsfleet.domain.dto.SingleVehicleModel;

import java.util.List;

public interface FleetDomainService {

    List<SingleVehicleModel> getListOfAllVehicles();
}
