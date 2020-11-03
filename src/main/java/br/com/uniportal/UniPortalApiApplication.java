package br.com.uniportal;

import org.springframework.boot.SpringApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAsync
public class UniPortalApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniPortalApiApplication.class, args);
	}

}
