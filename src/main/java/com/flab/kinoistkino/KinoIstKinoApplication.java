package com.flab.kinoistkino;

import com.flab.kinoistkino.model.User;
import com.flab.kinoistkino.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KinoIstKinoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(KinoIstKinoApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
	}
}
