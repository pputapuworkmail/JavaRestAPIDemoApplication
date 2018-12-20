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
	private String stationId;
	@Column(name="stationName")
	private String stationName;
	@Column(name="hdEnabled")
	private boolean hdEnabled;
	@Column(name="callSign")
	private String callSign;

}
