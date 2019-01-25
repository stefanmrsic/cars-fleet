package com.mtribes.carsfleet.repo.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity(name="Vehicle")
public class VehicleEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long vehicleId;
    private String address;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "coordinateId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private CoordinatesEntity coordinates;
    private String engineType;
    private String exterior;
    private int fuel;
    private String interior;
    private String name;
    private String vin;

    public VehicleEntity(){

    }

    public VehicleEntity(String address, CoordinatesEntity coordinates, String engineType, String exterior, int fuel, String interior, String name, String vin) {
        this.address = address;
        this.coordinates = coordinates;
        this.engineType = engineType;
        this.exterior = exterior;
        this.fuel = fuel;
        this.interior = interior;
        this.name = name;
        this.vin = vin;
    }

    public Long getId() {
        return vehicleId;
    }

    public String getAddress() {
        return address;
    }

    public CoordinatesEntity getCoordinates() {
        return coordinates;
    }

    public String getEngineType() {
        return engineType;
    }

    public String getExterior() {
        return exterior;
    }

    public int getFuel() {
        return fuel;
    }

    public String getInterior() {
        return interior;
    }

    public String getName() {
        return name;
    }

    public String getVin() {
        return vin;
    }
}
