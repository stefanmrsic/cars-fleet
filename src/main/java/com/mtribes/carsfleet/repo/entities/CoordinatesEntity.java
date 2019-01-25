package com.mtribes.carsfleet.repo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="Coordinates")
public class CoordinatesEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long coordinateId;
    private double latitude;
    private double longitude;
    private long altitude;

    protected CoordinatesEntity() {
    }

    public CoordinatesEntity(double longitude, double latitude, long altitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
    }

    public Long getId() {
        return coordinateId;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public long getAltitude() {
        return altitude;
    }
}
