package com.champit;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import lombok.extern.slf4j.Slf4j;

@EnableScheduling
@Slf4j
@SpringBootApplication
// @MapperScan(value = {"com.example.intra.dao"})
public class IntraApplication implements ApplicationRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(IntraApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info(" ■■■■■■■■ {} ■■■■■■■■", "챔프 LOCAL 인트라 START");
	}

}
