package com.railway.entity;

import java.time.LocalDate;

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
@Table(name = "booked_seats")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class BookedSeat extends BaseEntity {
	
	@Column(nullable = false)
	private LocalDate bookingDate;
	
	@Column(nullable = false)
	private int bookedSeats;
	
	@ManyToOne
	@JoinColumn(name = "train_class_id", nullable = false)
	private ClassInTrain trainClassId;
}
