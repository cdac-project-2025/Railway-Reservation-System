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
@Table(name = "bookings")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class Booking extends BaseEntity{
	@Column(nullable = false)
	private LocalDate bookingDate;
	
	@Column(length = 50, nullable = false)
	private String className;
	
	@Column(nullable = false)
	private LocalDate journeyDate;
	
	@Column(length = 10, nullable = false)
	private String phoneNo;
	
	@Column(length = 50, nullable = false)
	private String email;
	
	@Column(columnDefinition = "DECIMAL(10,2)", nullable = false)
	private double amount;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 10, nullable = false)
	private Status status;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User userId;
	
	@ManyToOne
	@JoinColumn(name = "train_number", nullable = false)
	private Train trainNumber;
	
	@ManyToOne
	@JoinColumn(name = "from_station", nullable = false)
	private Station fromStation;
	
	@ManyToOne
	@JoinColumn(name = "to_station", nullable = false)
	private Station toStation;

}
