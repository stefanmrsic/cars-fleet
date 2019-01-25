package com.mtribes.carsfleet.repo;

import com.mtribes.carsfleet.repo.entities.CoordinatesEntity;
import com.mtribes.carsfleet.repo.entities.VehicleEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class VehicleRepositoryTest {

    @Autowired
    private TestEntityManager em;
    @Autowired
    private VehicleRepository repository;

    @Test
    public void persistAndReturnSingleVehicle() {
        CoordinatesEntity coordinatesEntity = buildTestCoordinatesEntity();
        this.em.persistAndFlush(coordinatesEntity);
        final VehicleEntity vehicleEntity =
                this.em.persistAndFlush(buildTestVehicleEntityWithCoordinates(coordinatesEntity));
        VehicleEntity foundVehicle = repository.getOne(vehicleEntity.getId());
        assertThat(foundVehicle.getAddress()).isEqualTo(vehicleEntity.getAddress());
        em.remove(vehicleEntity);
    }

    private CoordinatesEntity buildTestCoordinatesEntity() {
        return new CoordinatesEntity(41, 20, 1);
    }

    private VehicleEntity buildTestVehicleEntityWithCoordinates(final CoordinatesEntity coordinatesEntity) {
        return new VehicleEntity("Test address", coordinatesEntity, "disel", "Hatch", 50, "black", "car1", "12121hrt");
    }
}
