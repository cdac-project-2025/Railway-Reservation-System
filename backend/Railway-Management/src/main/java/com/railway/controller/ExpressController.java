package com.railway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.railway.service.impl.ExpressService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ExpressController {
	private ExpressService expressService;
	
	@GetMapping("/call-express")
	public ResponseEntity<?> callExpress() {
			return ResponseEntity.status(HttpStatus.OK)
					.body(expressService.callExpressApi());
	}
}
