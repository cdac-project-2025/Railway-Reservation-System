package com.railway.service;

import java.util.List;

import com.railway.dto.SearchByStationCodeResDto;
import com.railway.dto.TrainScheduleDto;

public interface TrainRouteService {

	List<SearchByStationCodeResDto> searchByStation(String stationCode);

	List<TrainScheduleDto> getTrainSchedule(String trainNumber);

}
