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
public class PassengerModel {
	private String name;
	private Gender gender;
	private int age;
	private String berthPreference;
}
