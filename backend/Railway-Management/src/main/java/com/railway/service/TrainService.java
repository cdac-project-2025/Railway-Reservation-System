package com.railway.service;

import java.util.List;

import com.railway.dto.SearchByTrainNoResDto;
import com.railway.dto.SearchTrainReqDto;
import com.railway.dto.SearchTrainResDto;

public interface TrainService {

	List<SearchTrainResDto> searchForTrains(SearchTrainReqDto searchDto);

	SearchByTrainNoResDto searchByTrainNumber(String trainNumber);
	
}
