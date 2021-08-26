package com.github.JonathanAGomez.drivers;

import com.datastax.oss.driver.api.core.CqlSession;
import com.github.JonathanAGomez.drivers.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.server.adapter.WebHttpHandlerBuilder;
import reactor.core.publisher.Mono;
import reactor.netty.DisposableServer;
import reactor.netty.http.server.HttpServer;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
@ComponentScan
public class AppConfig {
    @Autowired
    DriverService driverService;

    @Bean
    public HttpServer httpServer(ApplicationContext context){
        HttpHandler handler = WebHttpHandlerBuilder.applicationContext(context).build();
        ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(handler);
        return HttpServer.create().port(8080).handle(adapter);
    }

    //@Bean
    //public DisposableServer server() throws URISyntaxException {
    //    Path error = Paths.get(DriversApplication.class.getResource("/error.html").toURI());
    //    Path index = Paths.get(DriversApplication.class.getResource("/index.html").toURI());
    //    return HttpServer.create()
    //            .port(8080)
    //            .route(routes ->
    //                    routes.get("/CustomerFormEntry", (request, response) ->
    //                            response.send(driverService.getAll()
    //                                    .map(DriversApplication::toByteBuf)
    //                                    .log("http-server")))
    //                            //Posts
    //                            .post("/CustomerFormEntry/add", (request, response) ->
    //                                    response.send(request.receive()
    //                                            .asString()
    //                                            .map(DriversApplication::parseCustomer)
    //                                            .map(driverService::create)
    //                                            .map(DriversApplication::toByteBuf)
    //                                            .log("http-server")))
//
    //                            //Gets
//
    //                            .get("/CustomerFormEntry/{param}", (request,response) ->
    //                                    response.send(driverService.get(Integer.parseInt(request.param("param")))
    //                                            .map(DriversApplication::toByteBuf)
    //                                            .log("http-server")))
//
    //                            .get("/CustomerFormEntry/{param}", (request,response) ->
    //                                    response.sendString(Mono.just(request.param("param"))
    //                                            .log("http-server")))
//
//
    //                            .get("/", (request, response) ->
    //                                    response.sendFile(index))
    //                            .get("/error", (request, response) ->
    //                                    response.status(404).addHeader("Output", "Error")
    //                                            .sendFile(error))
    //            )
    //            .bindNow();
    //}
}
