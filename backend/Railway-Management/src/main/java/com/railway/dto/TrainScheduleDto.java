package com.railway.dto;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrainScheduleDto {
	private int stnSerialNumber;
	private String stationName;
	private String stationCode;
	private int distance;
	private LocalTime arrivalTime;
	private LocalTime departureTime;
	private String haltTime;
	private int routeNumber;
	private int dayCount;
}
