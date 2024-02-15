package com.sample.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class LoginApplication1 {

	public static void main(String[] args) {
		SpringApplication.run(LoginApplication1.class, args);
	}

}
