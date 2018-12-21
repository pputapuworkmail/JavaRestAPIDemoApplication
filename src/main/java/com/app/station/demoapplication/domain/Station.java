package com.app.station.demoapplication.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Entity
public class Station {

	@Id
	@Column(name = "station_id")
	private String stationId;
	@Column(name = "station_name")
	private String stationName;
	@Column(name = "hd_enabled")
	private boolean hdEnabled;
	@Column(name = "call_sign")
	private String callSign;

}
