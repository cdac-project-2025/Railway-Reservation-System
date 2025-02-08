package com.railway.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.railway.entity.CompositeTrainKey;
import com.railway.entity.DivertedTrain;

public interface DivertedTrainDao extends JpaRepository<DivertedTrain, CompositeTrainKey> {
	
}
