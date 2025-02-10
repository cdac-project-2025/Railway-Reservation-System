package com.railway.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.railway.entity.Booking;
import com.railway.entity.User;

public interface BookingDao extends JpaRepository<Booking, Long> {

	Optional<List<Booking>> findByUserId(User user);

}
