package com.railway.entity;

import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "train_routes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class TrainRoute extends BaseEntity{
	
	@Column(nullable = false)
	private int stnSerialNumber;
	
	private LocalTime departureTime;
	
	private LocalTime arrivalTime;
	
	private int dayCount;
	
	private int routeNumber;
	
	@Column(length = 10)
	private String haltTime;
	
	private int distance;
	
	@ManyToOne
	@JoinColumn(name = "train_number", nullable = false)
	private Train trainNumber;

	@ManyToOne
	@JoinColumn(name = "station_code", nullable = false)
	private Station stationCode;
}
