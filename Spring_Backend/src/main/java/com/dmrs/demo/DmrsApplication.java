package com.dmrs.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DmrsApplication {
  public static final String crossOriginLink = "http://localhost:4200";
	public static void main(String[] args) {
		SpringApplication.run(DmrsApplication.class, args);
	}

}
