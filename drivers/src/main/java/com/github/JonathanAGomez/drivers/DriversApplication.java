package com.github.JonathanAGomez.drivers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.JonathanAGomez.drivers.domain.Driver;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import reactor.netty.http.server.HttpServer;
import reactor.netty.DisposableServer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.Duration;

@SpringBootApplication
public class DriversApplication {
	static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	public static void main(String[] args) {
		//SpringApplication.run(DriversApplication.class, args);
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);

		//appContext.getBean(DisposableServer.class).onDispose().block();
		appContext.getBean(HttpServer.class).bindUntilJavaShutdown(Duration.ofSeconds(60), null);

	}

	static ByteBuf toByteBuf(Object o){
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try{
			OBJECT_MAPPER.writeValue(out, o);
		} catch(IOException ex){
			ex.printStackTrace();
		}
		return ByteBufAllocator.DEFAULT.buffer().writeBytes(out.toByteArray());
	}

	static Driver parseCustomer(String str){
		Driver customer = null;
		try{ customer = OBJECT_MAPPER.readValue(str, Driver.class);
		} catch(JsonProcessingException ex) {
			ex.printStackTrace();
		}
		return customer;
	}

}