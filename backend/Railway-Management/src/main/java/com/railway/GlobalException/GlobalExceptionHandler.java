package com.railway.GlobalException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.railway.dto.ApiResponse;
import com.railway.exceptions.FieldNotAvailableException;
import com.railway.exceptions.ResourceNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ApiResponse handleRuntimeException(RuntimeException e) {
		return new ApiResponse(e.getMessage());
	}
	
	@ExceptionHandler(FieldNotAvailableException.class)
	@ResponseStatus(value = HttpStatus.CONFLICT)
	public ApiResponse handleFieldNotAvailableException(RuntimeException e) {
		return new ApiResponse(e.getMessage());
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ApiResponse handleResourceNotFoundException(ResourceNotFoundException e) {
		return new ApiResponse(e.getMessage());
	}
	
	@ExceptionHandler(MissingRequestHeaderException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ApiResponse handelMissingRequestHeaderException(MissingRequestHeaderException e) {
		return new ApiResponse("Missing header - " + e.getHeaderName());
	}
	
	@ExceptionHandler(NoResourceFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ApiResponse handelNoResourceFoundException(NoResourceFoundException e) {
		return new ApiResponse(e.getMessage());
	}
	
	@ExceptionHandler(MissingServletRequestParameterException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ApiResponse handelMissingServletRequestParameterException(MissingServletRequestParameterException e) {
		return new ApiResponse(e.getMessage());
	}
}
