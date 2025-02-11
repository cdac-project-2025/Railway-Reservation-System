package com.railway.service;

import com.railway.dto.ApiResponse;
import com.railway.dto.UserDetailsResponse;
import com.railway.dto.UserLoginDto;
import com.railway.dto.UserRegDto;

public interface UserService {
	ApiResponse registerUser(UserRegDto userDto);
	
	ApiResponse loginUser(UserLoginDto userDto);

	ApiResponse updateUser(UserRegDto userDto, Long id);

	ApiResponse deleteUser(Long id);

	UserDetailsResponse getUserDetails(Long id);
}