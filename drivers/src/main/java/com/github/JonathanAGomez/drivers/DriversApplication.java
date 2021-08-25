package com.github.JonathanAGomez.drivers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import reactor.netty.http.server.HttpServer;

import java.time.Duration;

@SpringBootApplication
public class DriversApplication {

	public static void main(String[] args) {
		SpringApplication.run(DriversApplication.class, args);
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);

		appContext.getBean(HttpServer.class).bindUntilJavaShutdown(Duration.ofSeconds(60), null);

	}

}