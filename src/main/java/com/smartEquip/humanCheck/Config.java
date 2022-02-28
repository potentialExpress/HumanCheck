package com.smartEquip.humanCheck;

import java.security.SecureRandom;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
	
	@Bean
    SecureRandom rand() {
        return new SecureRandom();
    }

}
