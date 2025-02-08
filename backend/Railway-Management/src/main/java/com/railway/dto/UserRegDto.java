package com.railway.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegDto {
	private String name;
	private String userName;
	private String password;
	private String email;
	private String phoneNo;
}
