package com.railway.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SeatAvailabilityResDto {
	private String trainNumber;
	private String className;
	private Long availableSeats;
	private double fare;
}
