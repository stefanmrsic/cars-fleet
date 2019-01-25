package com.mtribes.carsfleet.domain.dto;

public class SingleVehicleModel {
    private String address;
    private CoordinatesModel coordinates;
    private String engineType;
    private String exterior;
    private int fuel;
    private String interior;
    private String name;
    private String vin;

    private SingleVehicleModel() {

    }

    public SingleVehicleModel(SingleVehicleModel.Builder builder) {
        this.address = builder.address;
        this.coordinates = builder.coordinates;
        this.engineType = builder.engineType;
        this.exterior = builder.exterior;
        this.fuel = builder.fuel;
        this.interior = builder.interior;
        this.name = builder.name;
        this.vin = builder.vin;
    }

    public String getAddress() {
        return address;
    }

    public CoordinatesModel getCoordinates() {
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

    public static SingleVehicleModel.Builder builder() {
        return new SingleVehicleModel.Builder();
    }

    public static final class Builder {
        private String address;
        private CoordinatesModel coordinates;
        private String engineType;
        private String exterior;
        private int fuel;
        private String interior;
        private String name;
        private String vin;

        public Builder() {
        }

        public Builder withAddress(final String address) {
            this.address = address;
            return this;
        }

        public Builder withCoordinates(final CoordinatesModel coordinates) {
            this.coordinates = coordinates;
            return this;
        }

        public Builder withEngineType(final String engineType) {
            this.engineType = engineType;
            return this;
        }

        public Builder withInterior(final String interior) {
            this.interior = interior;
            return this;
        }

        public Builder withFuel(final int fuel) {
            this.fuel = fuel;
            return this;
        }

        public Builder withName(final String name) {
            this.name = name;
            return this;
        }

        public Builder withVin(final String vin) {
            this.vin = vin;
            return this;
        }

        public Builder withExterior(final String exterior) {
            this.exterior = exterior;
            return this;
        }

        public SingleVehicleModel build() {
            //TODO add element validator
            return new SingleVehicleModel(this);
        }

    }
}
