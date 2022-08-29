package com.flab.KinoistKino;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class KinoIstKinoApplication {

	public static void main(String[] args) {
		SpringApplication.run(KinoIstKinoApplication.class, args);
	}

}
