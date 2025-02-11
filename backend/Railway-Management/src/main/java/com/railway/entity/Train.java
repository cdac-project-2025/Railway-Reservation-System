package com.railway.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "trains")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Train {
	@Id
	@Column(length = 5, nullable = false, unique = true)
	private String trainNumber;
	
	@Column(length = 100, nullable = false)
	private String trainName;
	
	@ManyToOne
	@JoinColumn(name = "station_from", nullable = false)
	private Station stationFrom;
	
	@ManyToOne
	@JoinColumn(name = "station_to", nullable = false)
	private Station stationTo;
	
	@Column(length = 11, nullable = false)
	private String server;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 1, nullable = false)
	private TrainRunsOn runsOnMon;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 1, nullable = false)
	private TrainRunsOn runsOnTue;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 1, nullable = false)
	private TrainRunsOn runsOnWed;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 1, nullable = false)
	private TrainRunsOn runsOnThur;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 1, nullable = false)
	private TrainRunsOn runsOnFri;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 1, nullable = false)
	private TrainRunsOn runsOnSat;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 1, nullable = false)
	private TrainRunsOn runsOnSun;
	
	@Column(nullable = false)
	private LocalDateTime timeStamp;
	
	@CreationTimestamp
	private LocalDateTime createdOn;
	
	@UpdateTimestamp
	private LocalDateTime updatedOn;
}