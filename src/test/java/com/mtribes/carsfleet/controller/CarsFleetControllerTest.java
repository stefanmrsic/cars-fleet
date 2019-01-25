package com.mtribes.carsfleet.controller;

import com.mtribes.carsfleet.service.FleetService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.web.servlet.MockMvc;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Objects;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RestClientTest
@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(CarsFleetController.class)
public class CarsFleetControllerTest {

    private MockMvc mockMvc;

    @MockBean
    private FleetService fleetService;

    @InjectMocks
    private CarsFleetController carsFleetController;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = standaloneSetup(carsFleetController).build();
    }

//    @Test
//    public void getCompleteFleetTestOK() throws Exception {
//        this.mockMvc.perform(get("/fleet")).andExpect(status().isOk())
//                .andExpect(content().json(loadCompleteFleetJsonFromFile()));
//    }

    @Test
    public void getCompleteFleetTest_NoVehicles() throws Exception {
        this.mockMvc.perform(get("/fleet")).andExpect(status().isOk()).andExpect(Objects::isNull);
    }

    private String loadCompleteFleetJsonFromFile() throws IOException {
        final File resource = new File(
                "src/test/resources/fleet.txt");
        return new String(
                Files.readAllBytes(resource.toPath()));
    }
}
