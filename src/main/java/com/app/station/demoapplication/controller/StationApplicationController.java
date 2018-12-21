package com.app.station.demoapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.station.demoapplication.domain.Station;
import com.app.station.demoapplication.repository.StationApplicationRepository;
import com.app.station.demoapplication.service.StationApplicationService;

@RestController
@RequestMapping("/api/v1/station")
public class StationApplicationController {

	@Autowired
	private StationApplicationRepository stationRepository;

	@Autowired
	private StationApplicationService stationService;

	@PostMapping(value = "/create", produces = "application/json", consumes = "application/json")
	public ResponseEntity<Station> createStation(@RequestBody Station station) {

		station = stationService.createStation(station);
		return new ResponseEntity<>(station, HttpStatus.CREATED);

	}

	@DeleteMapping(value = "/delete", produces = "application/json")
	public void deleteStation(@RequestParam String stationId) {

		stationService.deleteStation(stationId);

	}

	@PutMapping(value = "/update/{stationName}", produces = "application/json", consumes = "application/json")
	public ResponseEntity<Object> UpdateStation(@RequestBody Station station, @PathVariable String stationName) {

		Station stationData = stationRepository.findByStationName(stationName);
		if (stationData == null)
			return ResponseEntity.notFound().build();

		station = stationService.createStation(station);

		return new ResponseEntity<>(station, HttpStatus.CREATED);

	}

	@GetMapping(value = "/get/allStations", produces = "application/json")
	public ResponseEntity<List<Station>> getAllStations() {

		List<Station> stations = stationService.retrieveAllStations();
		if (stations.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			System.out.println("LIST OF STATIONS " + stations + "SIZE " + stations.size());
			return new ResponseEntity<List<Station>>(stations, HttpStatus.OK);
		}

	}

	@GetMapping(value = "/search", produces = "application/json")
	public ResponseEntity<Station> searchStationsByName(@RequestParam(required = false) String stationName,
			@RequestParam(required = false) String stationId) {

		Station station = stationService.searchByStationName(stationName, stationId);

		if (station == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Station>(station, HttpStatus.OK);
		}

	}

	@GetMapping(value = "/searchByHdEnabled", produces = "application/json")
	public ResponseEntity<List<Station>> getAllHDEnabledStations(Boolean hdEnabled) {

		List<Station> stations = stationService.searchByHdEnabled(hdEnabled);
		if (stations.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<Station>>(stations, HttpStatus.OK);
		}

	}

}
