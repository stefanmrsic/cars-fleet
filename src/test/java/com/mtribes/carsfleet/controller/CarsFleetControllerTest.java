package com.mtribes.carsfleet.controller;

import com.mtribes.carsfleet.controller.dto.ImmutableVehicleCoordinate;
import com.mtribes.carsfleet.controller.dto.VehicleCoordinate;
import com.mtribes.carsfleet.service.FleetService;
import com.mtribes.carsfleet.service.dto.GetFleetSVCResponse;
import com.mtribes.carsfleet.service.dto.ImmutableGetFleetSVCResponse;
import com.mtribes.carsfleet.service.dto.ImmutableSingleVehicleSVCResponse;
import com.mtribes.carsfleet.service.dto.SingleVehicleSVCResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RestClientTest
@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(CarsFleetController.class)
public class CarsFleetControllerTest {

    @InjectMocks
    private CarsFleetController carsFleetController;

    @Mock
    private FleetService fleetService;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = standaloneSetup(carsFleetController).build();
    }

    @Test
    public void getCompleteFleetTest_TwoVehicles_OK() throws Exception {
        doReturn(buildTestFleetSvcResponse()).when(fleetService).getCompleteFleet();
        MvcResult result = this.mockMvc.perform(get("/fleet")).andExpect(status().isOk()).andReturn();
        assertEquals(result.getResponse().getContentAsString(), loadCompleteFleetJsonFromFile());
    }

    private GetFleetSVCResponse buildTestFleetSvcResponse() {
        return ImmutableGetFleetSVCResponse.builder().
                addAllListOfVehicles(buildListOfVehicleSvcResponses()).build();
    }

    private List<SingleVehicleSVCResponse> buildListOfVehicleSvcResponses() {
        final SingleVehicleSVCResponse firstVehicle = ImmutableSingleVehicleSVCResponse.builder()
                .address("adr1")
                .engineType("e1")
                .exterior("ex1")
                .interior("int1")
                .fuel(10)
                .name("n1")
                .vin("vin1")
                .coordinates(buildCoordinatesSvcResponse(1, 1, 0)).build();
        final SingleVehicleSVCResponse secondVehicle = ImmutableSingleVehicleSVCResponse.builder()
                .address("adr2")
                .engineType("e2")
                .exterior("ex2")
                .interior("int2")
                .fuel(20)
                .name("n2")
                .vin("vin2")
                .coordinates(buildCoordinatesSvcResponse(2, 2, 0)).build();
        return Arrays.asList(firstVehicle, secondVehicle);

    }

    private VehicleCoordinate buildCoordinatesSvcResponse(int latitude, int longitude, int altitude) {
        return ImmutableVehicleCoordinate.builder()
                .longitude(longitude)
                .latitude(latitude)
                .altitude(altitude).build();
    }

    private String loadCompleteFleetJsonFromFile() throws IOException {
        final File resource = new File(
                "src/test/resources/fleetResponse.txt");
        return new String(
                Files.readAllBytes(resource.toPath()));
    }
}
