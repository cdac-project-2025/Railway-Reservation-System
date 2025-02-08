package com.railway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.railway.dto.SearchTrainReqDto;
import com.railway.service.CancelledTrainService;
import com.railway.service.DivertedTrainService;
import com.railway.service.TrainRouteService;
import com.railway.service.TrainService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/trains")
@AllArgsConstructor
@CrossOrigin
public class TrainController {
	private TrainService trainService;
	private TrainRouteService trainRouteService;
	private CancelledTrainService cancelledTrainService; 
	private DivertedTrainService divertedTrainService;
	
	@PostMapping("/search")
	public ResponseEntity<?> searchForTrains(@RequestBody SearchTrainReqDto searchDto) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(trainService.searchForTrains(searchDto));
	}
	
	@GetMapping("/search/{stationCode}")
	public ResponseEntity<?> searchByStation(@PathVariable String stationCode) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(trainRouteService.searchByStation(stationCode));
	}
	
	@GetMapping("/search")
	public ResponseEntity<?> searchByTrainNumber(@RequestParam String trainNumber) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(trainService.searchByTrainNumber(trainNumber));
	}
	
	@GetMapping("/cancelled")
	public ResponseEntity<?> getCancelledTrains() {
		return ResponseEntity.status(HttpStatus.OK)
				.body(cancelledTrainService.getCancelledTrains());
	}
	
	@GetMapping("/diverted")
	public ResponseEntity<?> getDivertedTrains() {
		return ResponseEntity.status(HttpStatus.OK)
				.body(divertedTrainService.getDivertedTrains());
	}
	
	@GetMapping("/schedule")
	public ResponseEntity<?> getTrainSchedule(@RequestParam String trainNumber) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(trainRouteService.getTrainSchedule(trainNumber));
	}
}
