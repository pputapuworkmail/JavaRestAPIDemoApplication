package com.app.station.demoapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.station.demoapplication.domain.Station;

@Repository
public interface StationApplicationRepository extends JpaRepository<Station, String> {

	Station findByStationName(String stationName);
	
	Station findByStationNameOrStationId(String stationName, String stationId);

	Station findByStationId(String stationId);

	List<Station> findByHdEnabled(Boolean hdEnabled);

}
