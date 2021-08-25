package com.github.JonathanAGomez.drivers.controller;

import com.github.JonathanAGomez.drivers.domain.Driver;
import com.github.JonathanAGomez.drivers.service.DriverService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value ="/drivers")
public class DriverController {
    private final DriverService driverService;

    public DriverController(DriverService service){this.driverService = service;}

    @GetMapping("")
    public Flux<Driver> getAll(){return driverService.getAll();}

    @GetMapping("/{id}")
    public Mono<Driver> get(@PathVariable("id") int id){return driverService.get(id);}

    @PostMapping("")
    public Driver create(@RequestBody Driver driver){return driverService.create(driver);}
}
