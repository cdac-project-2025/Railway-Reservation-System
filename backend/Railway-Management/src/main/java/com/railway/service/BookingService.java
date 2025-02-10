package com.railway.service;

import java.util.List;

import com.railway.dto.ApiResponse;
import com.railway.dto.PassengerDetailsDto;
import com.railway.dto.SeatAvailabilityReqDto;
import com.railway.dto.SeatsAvailableResponseDto;
import com.railway.dto.TicketResponseDto;
import com.railway.dto.ViewTicketDto;

public interface BookingService {

	List<SeatsAvailableResponseDto> getAvailableSeats(SeatAvailabilityReqDto seatDto);

	TicketResponseDto bookTicket(PassengerDetailsDto psngDto, Long id);

	List<ViewTicketDto> getAllBookings(Long id);

	ViewTicketDto cancelBooking(Long bookingId);

	ApiResponse cancelTicket(Long passengerId);

}
