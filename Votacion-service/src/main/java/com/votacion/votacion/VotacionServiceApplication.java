package com.votacion.votacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class VotacionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VotacionServiceApplication.class, args);
	}

}
