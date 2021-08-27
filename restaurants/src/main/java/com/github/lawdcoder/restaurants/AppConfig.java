package com.github.lawdcoder.restaurants;

import com.datastax.oss.driver.api.core.CqlSession;
import com.github.lawdcoder.restaurants.service.RestaurantService;
import com.github.lawdcoder.restaurants.service.menuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.server.adapter.WebHttpHandlerBuilder;
import reactor.netty.http.server.HttpServer;



@Configuration
@ComponentScan

public class AppConfig {
    @Autowired
    RestaurantService restaurantService;
    menuService menuService;

    @Bean
    public HttpServer httpServer(ApplicationContext context){
        HttpHandler handler = WebHttpHandlerBuilder.applicationContext(context).build();
        ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(handler);
        return HttpServer.create().port(8080).handle(adapter);
    }
}
