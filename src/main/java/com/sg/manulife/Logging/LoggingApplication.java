package com.sg.manulife.Logging;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@Slf4j
@ComponentScan(basePackages = "com.sg.manulife.Logging")
public class LoggingApplication {

	public static void main(String[] args) {
		log.info("LoggingApplication*********");
		SpringApplication.run(LoggingApplication.class, args);
	}

}
