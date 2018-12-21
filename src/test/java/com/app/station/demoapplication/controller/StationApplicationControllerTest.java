package com.app.station.demoapplication.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.app.station.demoapplication.domain.Station;
import com.app.station.demoapplication.service.StationApplicationServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class StationApplicationControllerTest {

	@InjectMocks
	private StationApplicationController stationApplicationController;

	@InjectMocks
	private StationApplicationServiceImpl stationApplicatonServiceImpl;

	private MockMvc mvc;
	@Autowired
	private WebApplicationContext wac;

	private Station station1;

	@Before
	public void setup() {
		this.mvc = MockMvcBuilders.webAppContextSetup(wac).build();

		MockitoAnnotations.initMocks(this);
		station1 = new Station();
		station1.setStationId("100");
		station1.setStationName("California");
		station1.setHdEnabled(true);
		station1.setCallSign("AUGGHHJH");
	}

	@Test
	public void getAllStationsTest() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/api/v1/station/get/allStations").accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void searchStationsByHdEnabledTest() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/api/v1/station/searchByHdEnabled?hdEnabled=true")
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void createStationTest() throws Exception {

		mvc.perform(MockMvcRequestBuilders.post("/api/v1/station/create").content(asJsonString(station1))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated()).andExpect(MockMvcResultMatchers.jsonPath("$.stationId").exists());
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	public void updateEmployeeAPI() throws Exception {
		mvc.perform(MockMvcRequestBuilders.put("/api/v1/station/update/{stationName}", "Station2")
				.content(asJsonString(station1)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
	}

	@Test
	public void deleteEmployeeAPI() throws Exception {
		mvc.perform(MockMvcRequestBuilders.delete("/api/v1/station/delete?stationId=100001"))
				.andExpect(status().isOk());
	}
}
