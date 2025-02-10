package com.railway.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PassengerDetailsDto {
	private String trainNumber;
	private String trainName;
	private String stationFrom;
	private String stationTo;
	private LocalTime fromStationArrival;
	private LocalTime fromStationDeparture;
	private LocalTime toStationArrival;
	private LocalTime toStationDeparture;
	private LocalDate journeyDate;
	private String className;
	private double fare;
	private List<PassengerModel> passengers;
	private String phoneNumber;
	private String email;
}
