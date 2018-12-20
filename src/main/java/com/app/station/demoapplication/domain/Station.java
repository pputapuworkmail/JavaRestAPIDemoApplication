package com.app.station.demoapplication.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
public class Station {

	@Id
	@Column(name="station_id")
	private String stationId;
	@Column(name="station_name")
	private String stationName;
	@Column(name="hd_enabled")
	private boolean hdEnabled;
	@Column(name="call_sign")
	private String callSign;

}
