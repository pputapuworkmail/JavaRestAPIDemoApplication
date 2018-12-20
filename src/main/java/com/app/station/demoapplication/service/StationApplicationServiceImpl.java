package com.app.station.demoapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.station.demoapplication.domain.Station;
import com.app.station.demoapplication.repository.StationApplicationRepository;

@Service
public class StationApplicationServiceImpl implements StationApplicationService {

	@Autowired
	StationApplicationRepository stationRepository;

	@Override
	public Station createStation(Station station) {

		station = stationRepository.save(station);
		return station;
	}

	@Override
	public void deleteStation(String stationId) {
		stationRepository.delete(stationId);

	}

	@Override
	public Station updateStation(Station station) {

		station = stationRepository.save(station);
		return station;
	}

	@Override
	public List<Station> retrieveAllStations() {

		List<Station> stations = stationRepository.findAll();
		return stations;
	}

	@Override
	public Station searchByStationId(String stationId) {

		Station station = stationRepository.findByStationId(stationId);
		return station;
	}

	@Override
	public Station searchByStationName(String stationName) {

		Station station = stationRepository.findByStationName(stationName);
		return station;
	}

	@Override
	public List<Station> searchByHdEnabled(Boolean hdEnabled) {

		List<Station> stations = stationRepository.findByHdEnabled(hdEnabled);
		return stations;
	}

}
