package com.railway.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsResponse {
	private LocalDateTime timeStamp;
	private String status = "error";
	private UserDetailsDto data;
	
	public UserDetailsResponse(String status ,UserDetailsDto data) {
		this.timeStamp = LocalDateTime.now();
		this.status = status;
		this.data = data;
	}
}
