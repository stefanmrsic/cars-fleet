package com.mtribes.carsfleet.repo;

import com.mtribes.carsfleet.repo.entities.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<VehicleEntity, Long> {
}
