package com.mtribes.carsfleet.data;

import com.mtribes.carsfleet.domain.dto.SingleVehicleModel;
import com.mtribes.carsfleet.repo.VehicleRepository;
import com.mtribes.carsfleet.repo.entities.CoordinatesEntity;
import com.mtribes.carsfleet.repo.entities.VehicleEntity;
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
public class FleetDomainServiceTest {

    private static final String TEST_ADDRESS = "Test address";
    @Mock
    private VehicleRepository vehicleRepository;

    @InjectMocks
    private FleetDomainServiceImpl fleetDomainService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getCompleteVehicleDomainList_OK() {
        when(vehicleRepository.findAll()).thenReturn(buildTestListOfVehicleEntities());
        final List<SingleVehicleModel> vehicleModels =fleetDomainService.getListOfAllVehicles();
        assert(vehicleModels.size() == 1);
        assert(vehicleModels.get(0).getAddress().equals(TEST_ADDRESS));
    }

    private List<VehicleEntity> buildTestListOfVehicleEntities() {
        return Collections.singletonList(buildFirstVehicleEntity());
    }

    private VehicleEntity buildFirstVehicleEntity() {
        return new VehicleEntity(TEST_ADDRESS,
                buildTestCoordinatesEntity(),
                "disel",
                "Hatch",
                50,
                "black",
                "car1",
                "12121hrt");
    }

    private CoordinatesEntity buildTestCoordinatesEntity() {
        return new CoordinatesEntity(41, 20, 1);
    }
}
