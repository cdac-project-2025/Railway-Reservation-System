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
public class SearchTrainReqDto {
	private String stationFrom;
	private String stationTo;
	private LocalDate date;
}
