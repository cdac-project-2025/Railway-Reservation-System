package com.railway.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.railway.entity.Station;

public interface StationDao extends JpaRepository<Station, String> {
	
}
