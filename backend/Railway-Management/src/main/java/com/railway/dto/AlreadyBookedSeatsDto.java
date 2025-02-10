package com.railway.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlreadyBookedSeatsDto {
	private int seatNo;
	private LocalDate journeyDate;
	private String trainNumber;
	private String className;
}
