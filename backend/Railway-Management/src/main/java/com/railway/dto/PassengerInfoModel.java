package com.railway.dto;

import com.railway.entity.Gender;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PassengerInfoModel {
	private Long passengerId;
	private String name;
	private int age;
	private Gender gender;
	private String berthPreference;
	private int seatNo;
}
