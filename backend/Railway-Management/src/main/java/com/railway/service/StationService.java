package com.railway.service;

import com.railway.entity.Station;

public interface StationService {
	Station findByStationCode(String station);
}
