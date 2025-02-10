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
public class ViewTicketDto {
	private Long bookingId;
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
	private String phoneNumber;
	private String email;
	private double fare;
	private String status;
	private List<PassengerInfoModel> passengers;

}
