package com.railway;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RailwayManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(RailwayManagementApplication.class, args);
	}

    @Bean
    ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration()
		.setMatchingStrategy(MatchingStrategies.STRICT)
		.setPropertyCondition(Conditions.isNotNull());
		
		return modelMapper;
	}
    
    @Bean
    RestTemplate restTemplate() {
    	return new RestTemplate();
    }
}
