package com.mtribes.carsfleet.service;

import com.mtribes.carsfleet.controller.dto.ImmutableSingleVehicleResponse;
import com.mtribes.carsfleet.data.FleetDomainServiceImpl;
import com.mtribes.carsfleet.domain.FleetDomainService;
import com.mtribes.carsfleet.domain.dto.CoordinatesModel;
import com.mtribes.carsfleet.domain.dto.SingleVehicleModel;
import com.mtribes.carsfleet.repo.VehicleRepository;
import com.mtribes.carsfleet.repo.entities.CoordinatesEntity;
import com.mtribes.carsfleet.repo.entities.VehicleEntity;
import com.mtribes.carsfleet.service.dto.GetFleetSVCResponse;
import com.mtribes.carsfleet.service.impl.FleetServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FleetServiceTest {

    private static final String TEST_ADDRESS = "Test address";

    @Mock
    private FleetDomainService fleetDomainService;

    @InjectMocks
    private FleetServiceImpl fleetService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getCompleteVehicleSVCList_OK() {
        when(fleetDomainService.getListOfAllVehicles()).thenReturn(buildTestListOfAllVehicles());
        final GetFleetSVCResponse getFleetSVCResponse = fleetService.getCompleteFleet();
        assert (getFleetSVCResponse.getListOfVehicles().size() == 1);
        assert (getFleetSVCResponse.getListOfVehicles().get(0).getAddress().equals(TEST_ADDRESS));
    }

    private List<SingleVehicleModel> buildTestListOfAllVehicles() {
        return Collections.singletonList(buildFirstVehicleModel());
    }

    private SingleVehicleModel buildFirstVehicleModel() {
        return new SingleVehicleModel.Builder()
                .withAddress(TEST_ADDRESS)
                .withName("car1")
                .withVin("12121hrt")
                .withInterior("black")
                .withFuel(50)
                .withExterior("Hatch")
                .withEngineType("disel")
                .withCoordinates(buildTestCoordinatesModel())
                .build();
    }

    private CoordinatesModel buildTestCoordinatesModel() {
        return new CoordinatesModel.Builder().withLongitude(20).withLatitude(41).withAltitude(1).build();
    }

}
