package com.railway.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.railway.entity.CancelledTrain;
import com.railway.entity.CompositeTrainKey;

@Repository
public interface CancelledTrainDao extends JpaRepository<CancelledTrain, CompositeTrainKey> {
	
}
