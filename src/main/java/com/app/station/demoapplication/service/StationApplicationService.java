package com.app.station.demoapplication.service;

import java.util.List;

import com.app.station.demoapplication.domain.Station;

public interface StationApplicationService {

	Station createStation(Station station);
	
	void deleteStation(String stationId);
	
	Station updateStation(Station station);
	
	List<Station> retrieveAllStations();
	
	Station searchByStationId(String stationId);
	
	Station searchByStationName(String stationName);
	
	List<Station> searchByHdEnabled(Boolean hdEnabled);
}
