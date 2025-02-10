package com.railway.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.railway.dao.StationDao;
import com.railway.entity.Station;
import com.railway.exceptions.ResourceNotFoundException;
import com.railway.service.StationService;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class StationServiceImpl implements StationService {
	private StationDao stationDao;

	@Override
	public Station findByStationCode(String station) {
		Station stn = stationDao.findById(station)
				.orElseThrow(() -> new ResourceNotFoundException("Station does not exists" + station));
		
		return stn;
	}
}
