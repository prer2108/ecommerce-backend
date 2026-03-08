package com.kodnest.salessavyapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class SalesSavyAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesSavyAppApplication.class, args);
	}

}
