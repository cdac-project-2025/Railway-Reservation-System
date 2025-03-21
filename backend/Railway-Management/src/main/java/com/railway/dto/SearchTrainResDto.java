package com.railway.dto;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SearchTrainResDto {
	private String fromStation;
	private String toStation;
	private LocalTime fromStationArrival;
	private LocalTime fromStationDeparture;
	private LocalTime toStationArrival;
	private LocalTime toStationDeparture;
	private String trainNumber;
	private String trainName;
}
