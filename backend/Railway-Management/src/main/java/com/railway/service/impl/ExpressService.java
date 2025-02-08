package com.railway.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.railway.dto.ExpressDto;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ExpressService {
	private RestTemplate restTemplate;
	
	public ExpressDto callExpressApi() {
        String url = "http://localhost:4000/api/data";
        return restTemplate.getForObject(url, ExpressDto.class);
    }
}