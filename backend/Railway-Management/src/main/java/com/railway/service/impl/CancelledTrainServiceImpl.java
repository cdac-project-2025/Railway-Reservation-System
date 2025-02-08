package com.railway.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.railway.dao.CancelledTrainDao;
import com.railway.entity.CancelledTrain;
import com.railway.exceptions.ResourceNotFoundException;
import com.railway.service.CancelledTrainService;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class CancelledTrainServiceImpl implements CancelledTrainService {
	private CancelledTrainDao cancelledTrainDao;

	@Override
	public List<CancelledTrain> getCancelledTrains() {
		List<CancelledTrain> trains = cancelledTrainDao.findAll();
		if(trains.isEmpty())
			throw new ResourceNotFoundException("No cancelled trains at the moment!");
		
		return trains;
	}

}
