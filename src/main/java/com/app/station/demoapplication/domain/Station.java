package com.app.station.demoapplication.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
public class Station {

	@Id
	private String stationId;
	private String stationName;
	private boolean hdEnabled;
	private String callSign;

}
