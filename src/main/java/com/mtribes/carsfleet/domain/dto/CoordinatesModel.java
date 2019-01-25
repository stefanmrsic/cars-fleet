package com.mtribes.carsfleet.domain.dto;

public class CoordinatesModel {

    private double lat;
    private double lon;
    private double alt;

    public CoordinatesModel() {

    }

    public CoordinatesModel (CoordinatesModel.Builder builder){
        this.lat = builder.latitude;
        this.lon = builder.longitude;
        this.alt = builder.altitude;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public double getAlt() {
        return alt;
    }

    public static CoordinatesModel.Builder builder() {
        return new CoordinatesModel.Builder();
    }
    public static class Builder {

        private double latitude;
        private double longitude;
        private double altitude;

        public Builder() {

        }
        public static CoordinatesModel.Builder builder() {
            return new CoordinatesModel.Builder();
        }

        public CoordinatesModel.Builder withLatitude(final double latitude){
            this.latitude = latitude;
            return this;
        }
        public CoordinatesModel.Builder withLongitude(final double longitude){
            this.longitude = longitude;
            return this;
        }
        public CoordinatesModel.Builder withAltitude(final double altitude){
            this.altitude = altitude;
            return this;
        }

        public CoordinatesModel build() {
            //TODO add element validator
            return new CoordinatesModel(this);
        }
    }

}
