package com.railway.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.railway.dto.AlreadyBookedSeatsDto;
import com.railway.entity.Booking;
import com.railway.entity.Passenger;

public interface PassengerDao extends JpaRepository<Passenger, Long> {
	
	@Query("SELECT NEW com.railway.dto.AlreadyBookedSeatsDto (p.seatNo, p.journeyDate, "
			+ "p.trainNumber, p.className) "
			+ "FROM Passenger p "
			+ "GROUP BY p.journeyDate, p.trainNumber, p.className, p.seatNo "
			+ "HAVING p.journeyDate=:journeyDate and p.trainNumber=:trainNumber and p.className=:className")
	List<AlreadyBookedSeatsDto> getAlreadyBookedSeats(String trainNumber, String className, LocalDate journeyDate);

	List<Passenger> findByBookingId(Booking id);
}
