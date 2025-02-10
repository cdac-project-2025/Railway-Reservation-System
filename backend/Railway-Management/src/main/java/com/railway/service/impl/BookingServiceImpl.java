package com.railway.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.railway.dao.AllClassDao;
import com.railway.dao.BookedSeatDao;
import com.railway.dao.BookingDao;
import com.railway.dao.ClassInTrainDao;
import com.railway.dao.PassengerDao;
import com.railway.dao.StationDao;
import com.railway.dao.TrainDao;
import com.railway.dao.TrainRouteDao;
import com.railway.dao.UserDao;
import com.railway.dto.AlreadyBookedSeatsDto;
import com.railway.dto.ApiResponse;
import com.railway.dto.PassengerDetailsDto;
import com.railway.dto.PassengerInfoModel;
import com.railway.dto.PassengerModel;
import com.railway.dto.SeatAvailabilityReqDto;
import com.railway.dto.SeatAvailabilityResDto;
import com.railway.dto.SeatsAvailableResponseDto;
import com.railway.dto.TicketModel;
import com.railway.dto.TicketResponseDto;
import com.railway.dto.ViewTicketDto;
import com.railway.entity.AllClass;
import com.railway.entity.BookedSeat;
import com.railway.entity.Booking;
import com.railway.entity.ClassInTrain;
import com.railway.entity.Passenger;
import com.railway.entity.Station;
import com.railway.entity.Status;
import com.railway.entity.Train;
import com.railway.entity.TrainRoute;
import com.railway.entity.User;
import com.railway.exceptions.ResourceNotFoundException;
import com.railway.service.BookingService;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {
	
	private ClassInTrainDao classInTrainDao;
	private TrainDao trainDao;
	private UserDao userDao;
	private StationDao stationDao;
	private BookingDao bookingDao;
	private PassengerDao passengerDao;
	private BookedSeatDao bookedSeatDao;
	private AllClassDao allClassDao;
	private TrainRouteDao trainRouteDao;
	
	private int allotSeatNumber(String className) {
		Random random = new Random();
		
		switch (className) {
			case "acFirstClass": return random.nextInt(30)+1;
			case "acSecondClass": return random.nextInt(60)+1;
			case "acThirdClass": return random.nextInt(90)+1;
			case "acChairCar": return random.nextInt(60)+1;
			case "nonAcChairCar": return random.nextInt(180)+1;
			case "sleeper": return random.nextInt(120)+1;

			default: return 0;
		}
	}
	
	private int getAvailableSeats(Train train, LocalDate date, String className) {
		
		List<SeatAvailabilityResDto> seats = classInTrainDao.getAvailableSeats(train, date).stream()
				.filter(s ->  s.getClassName().equals(className)).toList();
		
		return seats.iterator().next().getAvailableSeats().intValue();
		
	}
	
	private int totalAvailableSeats(String className) {
		
		switch (className) {
			case "acFirstClass": return 30;
			case "acSecondClass": return 60;
			case "acThirdClass": return 90;
			case "acChairCar": return 60;
			case "nonAcChairCar": return 180;
			case "sleeper": return 120;
	
			default: return -1;
		}
	}
	
	@Override
	public List<SeatsAvailableResponseDto> getAvailableSeats(SeatAvailabilityReqDto seatDto) {
		
		Train train = trainDao.findById(seatDto.getTrainNumber())
				.orElseThrow(() -> new ResourceNotFoundException("No such train - " + seatDto.getTrainNumber()));
		
		List<SeatAvailabilityResDto> seats = classInTrainDao.getAvailableSeats(train, seatDto.getDate());
		
		if(seats.isEmpty())
			throw new ResourceNotFoundException("No seats avavilable!");
		
		return seats.stream().map((s) -> {
			return new SeatsAvailableResponseDto(train,
					train.getStationFrom().getStationCode(), 
					train.getStationTo().getStationCode(), 
					s.getClassName(),s.getAvailableSeats().intValue(),s.getFare());
		}).collect(Collectors.toList());
	}

	@Override
	public TicketResponseDto bookTicket(PassengerDetailsDto psngDto, Long id) {
		User user = userDao.findById(id).get();
		Train train = trainDao.findById(psngDto.getTrainNumber()).get();
		Station stationFrom = stationDao.findById(psngDto.getStationFrom()).get();
		Station stationTo = stationDao.findById(psngDto.getStationTo()).get();
		AllClass c = allClassDao.findById(psngDto.getClassName()).get();
		System.out.println(user);
		System.out.println(train);
		System.out.println(stationFrom);
		System.out.println(stationTo);
		
		Booking b = bookingDao.save(new Booking(LocalDate.now(), psngDto.getClassName(), psngDto.getJourneyDate(), 
				psngDto.getPhoneNumber(), psngDto.getEmail(), psngDto.getFare(), Status.BOOKED ,user, train, stationFrom, stationTo));
		
		List<TicketModel> tList = new ArrayList<>();
		
		int seats = 0;
		
		for(int i=0; i<psngDto.getPassengers().size(); i++) {
			if((seats = getAvailableSeats(train, psngDto.getJourneyDate(), psngDto.getClassName())) != 0) {
				List<AlreadyBookedSeatsDto> seatList = passengerDao.getAlreadyBookedSeats
						(psngDto.getTrainNumber(), psngDto.getClassName(), psngDto.getJourneyDate());
				
				Set<Integer> allottedSeats = seatList.stream().map(s -> s.getSeatNo()).collect(Collectors.toSet());
				int seatNumber = 0;
				
				while(true) {
					seatNumber = allotSeatNumber(psngDto.getClassName());
					if(!allottedSeats.contains(seatNumber))
						break;
				}
				
				Passenger p = new Passenger();
				PassengerModel tmp = psngDto.getPassengers().get(i);
				
				p.setName(tmp.getName());
				p.setAge(tmp.getAge());
				p.setGender(tmp.getGender());
				p.setBerthPreference(tmp.getBerthPreference());
				p.setSeatNo(seatNumber);
				p.setClassName(psngDto.getClassName());
				p.setJourneyDate(psngDto.getJourneyDate());
				p.setTrainNumber(psngDto.getTrainNumber());
				p.setStatus(Status.BOOKED);
				p.setBookingId(b);
				
				passengerDao.save(p);
				tList.add(new TicketModel(p.getName(), p.getSeatNo()));
				ClassInTrain tClass = classInTrainDao.findByTrainNumberAndClassName(train, c);
				
				if(seats == totalAvailableSeats(psngDto.getClassName()))
					bookedSeatDao.save(new BookedSeat(LocalDate.now(), psngDto.getJourneyDate(), 1, tClass));
				else {
					BookedSeat bSeat = bookedSeatDao.findByBookingDateAndJourneyDateAndTrainClassId(LocalDate.now(), 
							psngDto.getJourneyDate(), tClass);
					bSeat.setBookedSeats(bSeat.getBookedSeats()+1);
					bookedSeatDao.save(bSeat);
				}
			}
		}
		
		TicketResponseDto ticketRes = new TicketResponseDto();
		
		if(tList.size() == 0)
			ticketRes.setStatus("Booking failed");
		else if(tList.size() < psngDto.getPassengers().size()) {
			ticketRes.setStatus("Partial booking");
			ticketRes.setBookingId(b.getId());
		}
		else {
			ticketRes.setStatus("Fully booking");
			ticketRes.setBookingId(b.getId());
		}
			
		ticketRes.setPassengers(tList);
		
		return ticketRes;
	}

	@Override
	public List<ViewTicketDto> getAllBookings(Long id) {
		List<Booking> bList = bookingDao.findByUserId(userDao.findById(id).get())
				.orElseThrow(() -> new ResourceNotFoundException("No bookings found"));
		
		List<ViewTicketDto> vList = new ArrayList<>();
		
		for(Booking b : bList) {
			List<Passenger> pList = passengerDao.findByBookingId(b);
			
			List<Passenger> filteredPList = pList.stream().filter(p -> p.getStatus().name().equals("BOOKED")).toList();
			
			List<PassengerInfoModel> pInfoList = filteredPList.stream()
					.map(p -> {return new PassengerInfoModel(p.getId(), p.getName(), p.getAge(), p.getGender(), 
							p.getBerthPreference(), p.getSeatNo());}).toList();
			
			TrainRoute from = trainRouteDao.findByTrainNumberAndStationCode(b.getTrainNumber(), b.getFromStation());
			TrainRoute to = trainRouteDao.findByTrainNumberAndStationCode(b.getTrainNumber(), b.getToStation());
			
			vList.add(new ViewTicketDto(
					b.getId(), b.getTrainNumber().getTrainNumber(), b.getTrainNumber().getTrainName(), 
					b.getFromStation().getStationCode(), b.getToStation().getStationCode(), from.getArrivalTime(), 
					from.getDepartureTime(), to.getArrivalTime(), to.getDepartureTime(), b.getJourneyDate(), 
					b.getClassName(), b.getPhoneNo(), b.getEmail(), b.getAmount(), b.getStatus().name(), pInfoList));
			
		}
		
		return vList;
	}

	@Override
	public ViewTicketDto cancelBooking(Long bookingId) {
		Booking b = bookingDao.findById(bookingId).get();
		b.setStatus(Status.CANCELLED);
		
		List<Passenger> pList = passengerDao.findByBookingId(b);
		pList.forEach(s -> s.setStatus(Status.CANCELLED));
		
		//No. of seats currently avavilable logic
		AllClass className =  allClassDao.findById(b.getClassName()).get();
		ClassInTrain tc = classInTrainDao.findByTrainNumberAndClassName(b.getTrainNumber(), className);
		
		BookedSeat bs = bookedSeatDao.findByTrainClassIdAndJourneyDateAndBookingDate(tc, b.getJourneyDate(), b.getBookingDate());
		bookedSeatDao.delete(bs);
		
		List<PassengerInfoModel> pInfoList = pList.stream()
				.map(p -> {return new PassengerInfoModel(p.getId(), p.getName(), p.getAge(), p.getGender(), 
						p.getBerthPreference(), p.getSeatNo());}).toList();
		
		TrainRoute from = trainRouteDao.findByTrainNumberAndStationCode(b.getTrainNumber(), b.getFromStation());
		TrainRoute to = trainRouteDao.findByTrainNumberAndStationCode(b.getTrainNumber(), b.getToStation());
		
		return new ViewTicketDto(
				b.getId(), b.getTrainNumber().getTrainNumber(), b.getTrainNumber().getTrainName(), 
				b.getFromStation().getStationCode(), b.getToStation().getStationCode(), from.getArrivalTime(), 
				from.getDepartureTime(), to.getArrivalTime(), to.getDepartureTime(), b.getJourneyDate(), 
				b.getClassName(), b.getPhoneNo(), b.getEmail(), b.getAmount(), b.getStatus().name(), pInfoList);
	}

	@Override
	public ApiResponse cancelTicket(Long passengerId) {
		Passenger p = passengerDao.findById(passengerId).get();
		
		Booking b = bookingDao.findById(p.getBookingId().getId()).get();
		AllClass className =  allClassDao.findById(b.getClassName()).get();
		ClassInTrain tc = classInTrainDao.findByTrainNumberAndClassName(b.getTrainNumber(), className);
		BookedSeat bs = bookedSeatDao.findByTrainClassIdAndJourneyDateAndBookingDate(tc, b.getJourneyDate(), b.getBookingDate());
		bs.setBookedSeats(bs.getBookedSeats()-1);
		
		p.setStatus(Status.CANCELLED);
		
		return new ApiResponse("Ticket cancelled successfully");
	}

}
