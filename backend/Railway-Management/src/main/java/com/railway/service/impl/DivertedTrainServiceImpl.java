package com.railway.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.railway.dao.DivertedTrainDao;
import com.railway.entity.DivertedTrain;
import com.railway.exceptions.ResourceNotFoundException;
import com.railway.service.DivertedTrainService;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class DivertedTrainServiceImpl implements DivertedTrainService {
	
	private DivertedTrainDao divertedTrainDao;
	
	@Override
	public List<DivertedTrain> getDivertedTrains() {
		List<DivertedTrain> trains = divertedTrainDao.findAll();
		if(trains.isEmpty())
			throw new ResourceNotFoundException("No diverted trains at the moment!");
		
		return trains;
	}

}
