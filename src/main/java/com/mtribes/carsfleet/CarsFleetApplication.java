package com.mtribes.carsfleet;

import com.mtribes.carsfleet.repo.VehicleRepository;
import com.mtribes.carsfleet.repo.entities.CoordinatesEntity;
import com.mtribes.carsfleet.repo.entities.VehicleEntity;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@SpringBootApplication
public class CarsFleetApplication {

    @Autowired
    private VehicleRepository vehicleRepository;

    public static void main(String[] args) {
        SpringApplication.run(CarsFleetApplication.class, args);
    }


    @PostConstruct
    public void setupDbWithData() throws IOException, ParseException {
        vehicleRepository.saveAll(loadArrayOfVehiclesFromFile());
    }

    private List<VehicleEntity> loadArrayOfVehiclesFromFile() throws IOException, ParseException {
        final JSONParser parser = new JSONParser();
        final JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("src/main/resources/fleet.txt"));;
        final JSONArray vehicleJsonArray = (JSONArray) jsonObject.get("placemarks");

         return (List<VehicleEntity>) vehicleJsonArray.stream()
                 .map(this::buildVehicleEntityFromJson)
                 .collect(Collectors.toList());
    }

    private VehicleEntity buildVehicleEntityFromJson(Object singleObject) {
        JSONObject jsonObject = (JSONObject) singleObject;
        return new VehicleEntity(
                jsonObject.get("address").toString(),
                buildCoordinatesEntityFromJsonObject((JSONArray) jsonObject.get("coordinates")),
                jsonObject.get("engineType").toString(),
                jsonObject.get("exterior").toString(),
                ((Long) jsonObject.get("fuel")).intValue(),
                jsonObject.get("interior").toString(),
                jsonObject.get("name").toString(),
                jsonObject.get("vin").toString());
    }
    private CoordinatesEntity buildCoordinatesEntityFromJsonObject(JSONArray coordinates) {
        return new CoordinatesEntity((Double)coordinates.get(0),
                (Double)coordinates.get(1),
                (Long)coordinates.get(2));
    }
}

