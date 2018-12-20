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
	@Column(name="stationid")
	private String stationId;
	@Column(name="stationname")
	private String stationName;
	@Column(name="hdenabled")
	private boolean hdEnabled;
	@Column(name="callsign")
	private String callSign;

}
