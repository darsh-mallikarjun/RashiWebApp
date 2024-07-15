package com.rashi.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(webconfig.class)
public class RashiApplication1Application {

	public static void main(String[] args) {
		SpringApplication.run(RashiApplication1Application.class, args);
	}

}
