package com.railway.dao;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.railway.entity.BookedSeat;
import com.railway.entity.ClassInTrain;

@Repository
public interface BookedSeatDao extends JpaRepository<BookedSeat, Long> {

	BookedSeat findByBookingDateAndJourneyDateAndTrainClassId(LocalDate date, LocalDate journeyDate, ClassInTrain tClass);

	BookedSeat findByTrainClassIdAndJourneyDateAndBookingDate(ClassInTrain tc, LocalDate journeyDate, LocalDate bookingDate);
	
}
