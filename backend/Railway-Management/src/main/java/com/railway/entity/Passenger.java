package com.railway.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "passengers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class Passenger extends BaseEntity {
	@Column(length = 50, nullable = false)
	private String name;
	
	@Column(nullable = false)
	private int age;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 6, nullable = false)
	private Gender gender;
	
	@Column(length = 20, nullable = false)
	private String berthPreference;
	
	private int seatNo;
	
	@Column(length = 20, nullable = false)
	private String className;
	
	@Column(nullable = false)
	private LocalDate journeyDate;
	
	@Column(length = 20, nullable = false)
	private String trainNumber;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 10, nullable = false)
	private Status status;
	
	@ManyToOne
	@JoinColumn(name = "booking_id", nullable = false)
	private Booking bookingId;
}