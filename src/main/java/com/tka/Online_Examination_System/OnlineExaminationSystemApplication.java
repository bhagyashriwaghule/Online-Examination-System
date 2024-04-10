package com.tka.Online_Examination_System;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com")
@EntityScan("com")
public class OnlineExaminationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineExaminationSystemApplication.class, args);
	System.out.println("Online Examination System.....");
	
	
	
	

	}

}
