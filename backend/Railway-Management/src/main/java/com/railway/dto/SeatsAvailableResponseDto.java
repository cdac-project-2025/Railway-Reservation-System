package com.railway.dto;

import com.railway.entity.Train;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SeatsAvailableResponseDto {
	private Train trainNumber;
	private String fromStationCode;
	private String toStationCode;
	private String className;
	private int availableSeats;
	private double fare;
}
