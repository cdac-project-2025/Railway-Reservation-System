package com.railway.dto;

import com.railway.entity.Station;
import com.railway.entity.TrainRunsOn;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SearchByTrainNoResDto {
	private String trainName;
	private Station stationFrom;
	private Station stationTo;
	private TrainRunsOn runsOnMon;
	private TrainRunsOn runsOnTue;
	private TrainRunsOn runsOnWed;
	private TrainRunsOn runsOnThur;
	private TrainRunsOn runsOnFri;
	private TrainRunsOn runsOnSat;
	private TrainRunsOn runsOnSun;
}
