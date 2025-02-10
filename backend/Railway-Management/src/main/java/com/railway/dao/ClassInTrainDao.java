package com.railway.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.railway.dto.SeatAvailabilityResDto;
import com.railway.entity.AllClass;
import com.railway.entity.ClassInTrain;
import com.railway.entity.Train;

@Repository
public interface ClassInTrainDao extends JpaRepository<ClassInTrain, Long> {
	
	@Query("SELECT NEW com.railway.dto.SeatAvailabilityResDto(tc.trainNumber.trainNumber, c.className, "
			+ "tc.availableSeats-IFNULL(bs.bookedSeats, 0), tc.fare) "
			+ "FROM ClassInTrain tc JOIN AllClass c ON tc.className.className = c.className "
			+ "LEFT JOIN "
			+ "(SELECT trainClassId.id AS trainClassId, SUM(bookedSeats) AS bookedSeats "
			+ "FROM BookedSeat "
			+ "WHERE journeyDate=:date "
			+ "GROUP BY trainClassId.id) bs "
			+ "ON tc.id = bs.trainClassId "
			+ "WHERE tc.trainNumber=:trainNumber")
	List<SeatAvailabilityResDto> getAvailableSeats(Train trainNumber, LocalDate date);
	
	ClassInTrain findByTrainNumberAndClassName(Train trainNumber, AllClass className);
}
