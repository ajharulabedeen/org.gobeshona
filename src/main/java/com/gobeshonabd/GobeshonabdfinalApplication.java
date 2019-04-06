package com.gobeshonabd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:gobeshonabdSpringBeans.xml")
public class GobeshonabdfinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(GobeshonabdfinalApplication.class, args);
	}
}
