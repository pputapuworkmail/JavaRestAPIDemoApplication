package com.app.station.demoapplication.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.app.station.demoapplication.domain.Station;
import com.app.station.demoapplication.repository.StationApplicationRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class StationApplicationServiceTest {

	@Mock
	private StationApplicationService stationApplicationService;

	@InjectMocks
	private StationApplicationServiceImpl stationApplicationServiceImpl;

	@Mock
	private StationApplicationRepository stationApplicationRepository;

	private List<Station> list;
	private Station station1;
	private Station station2;
	private Station station3;
	private Station station4;

	@Before
	public void init() {

		MockitoAnnotations.initMocks(this);

		list = new ArrayList<>();

		station1 = new Station();
		station1.setStationId("100");
		station1.setStationName("California");
		station1.setHdEnabled(true);
		station1.setCallSign("AUGGHHJH");

		station2 = new Station();
		station2.setStationId("200");
		station2.setStationName("Washington");
		station2.setHdEnabled(true);
		station2.setCallSign("XHYSKJDK");

		station3 = new Station();
		station3.setStationId("300");
		station3.setStationName("Wisconsin");
		station3.setHdEnabled(false);
		station3.setCallSign("FJKSJLKJS");

		station4 = new Station();
		station4.setStationId("400");
		station4.setStationName("Chicago");
		station4.setHdEnabled(false);
		station4.setCallSign("HDKDJKDD");

		list.add(station1);
		list.add(station2);
		list.add(station3);

	}

	@Test
	public void createStationTest() {
		when(stationApplicationService.createStation(station1)).thenReturn(station1);
		station1 = stationApplicationService.createStation(station1);
		assertEquals("California", station1.getStationName());
		assertNotNull(station1);
	}

	@Test
	public void updateStationTest() {

		station3.setCallSign("WJFJHFJF");
		when(stationApplicationService.updateStation(station3)).thenReturn(station3);
		station3 = stationApplicationService.updateStation(station3);
		assertEquals("WJFJHFJF", station3.getCallSign());
		assertNotNull(station3);
	}

	@Test
	public void deleteStationTest() {

		list.add(station4);
		doNothing().when(stationApplicationService).deleteStation("400");
		stationApplicationService.deleteStation("400");
		verify(stationApplicationService, times(1)).deleteStation(station4.getStationId());

	}

	@Test
	public void getAllStationsServiceTest() {

		when(stationApplicationService.retrieveAllStations()).thenReturn(list);
		list = stationApplicationService.retrieveAllStations();
		assertEquals(3, list.size());
	}

	@Test
	public void searchStationByStationNameOrStationIdTest() {
		when(stationApplicationService.searchByStationNameOrStationId("Washington", "200")).thenReturn(station2);
		assertEquals("200", station2.getStationId());
		assertEquals("Washington", station2.getStationName());
		assertEquals(true, station2.isHdEnabled());
		assertEquals("XHYSKJDK", station2.getCallSign());
		assertNotNull(station2);
	}

	@Test
	public void searchStationsByHdEnabledTest() {
		List<Station> hdEnabledStationsList = new ArrayList<>();
		hdEnabledStationsList.add(station1);
		hdEnabledStationsList.add(station2);
		when(stationApplicationService.searchByHdEnabled(true)).thenReturn(hdEnabledStationsList);
		hdEnabledStationsList = stationApplicationService.searchByHdEnabled(true);
		assertEquals(2, hdEnabledStationsList.size());
		assertEquals("California", hdEnabledStationsList.get(0).getStationName());

	}

}