package com.railway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.railway.dto.PassengerDetailsDto;
import com.railway.dto.SeatAvailabilityReqDto;
import com.railway.service.BookingService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/bookings")
@AllArgsConstructor
@CrossOrigin
public class BookingController {
	
	private BookingService bookingService;
	
	@PostMapping("/seats")
	public ResponseEntity<?> getAvailableSeats(@RequestBody SeatAvailabilityReqDto seatDto) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(bookingService.getAvailableSeats(seatDto));
	}
	
	@PostMapping("/psngr-details") //                                             **Replace this with jwt token
	public ResponseEntity<?> bookTicket(@RequestBody PassengerDetailsDto psngDto, @RequestHeader Long id) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(bookingService.bookTicket(psngDto, id));
	}
	
	@GetMapping("/view-bookings")//       **Replace this with jwt token
	public ResponseEntity<?> viewBookings(@RequestHeader Long id) {
		return ResponseEntity.status(HttpStatus.OK)
					.body(bookingService.getAllBookings(id));
	}
	
	@PutMapping("/cancel-booking/{bookingId}")
	public ResponseEntity<?> cancelBooking(@PathVariable Long bookingId) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(bookingService.cancelBooking(bookingId));
	}
	
	@PutMapping("/cancel-ticket/{passengerId}")
	public ResponseEntity<?> cancelTicket(@PathVariable Long passengerId) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(bookingService.cancelTicket(passengerId));
	}
}
