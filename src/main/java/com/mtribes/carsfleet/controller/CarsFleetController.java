package com.mtribes.carsfleet.controller;


import com.mtribes.carsfleet.controller.dto.CompleteFleetResponse;
import com.mtribes.carsfleet.service.FleetService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarsFleetController {

    private final FleetService fleetService;

    public CarsFleetController(FleetService fleetService) {
        this.fleetService = fleetService;
    }

    @RequestMapping("/fleet")
    public @ResponseBody
    CompleteFleetResponse getCompleeteFleet() {

        // fleetService.getConpleteFleet();
        return null;//ImmutableCompleteFleetResponse.builder().addAllListOfCars();
    }

}
