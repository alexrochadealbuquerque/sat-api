package com.br.sat;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SatApiApplication {

    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }

	public static void main(String[] args) {
		SpringApplication.run(SatApiApplication.class, args);
	}

}
