package com.railway.dto;

import java.time.LocalTime;

import com.railway.entity.Station;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SearchByStationCodeResDto {
	private String trainNumber;
	private String trainName;
	private LocalTime arrivalTime;
	private LocalTime departureTime;
	private Station stationFrom;
	private Station stationTo;
	private String haltTime;
}
