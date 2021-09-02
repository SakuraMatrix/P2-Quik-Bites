package com.github.JonathanAGomez.drivers.controller;

import com.github.JonathanAGomez.drivers.domain.Driver;
import com.github.JonathanAGomez.drivers.service.DriverService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("")
public class DriverController {
    private final DriverService driverService;

    public DriverController(DriverService service){this.driverService = service;}

    @GetMapping("")
    public Flux<Driver> getAll(){return driverService.getAll();}

    @GetMapping("/error")
    public String getError(){return driverService.printData();}

    @GetMapping("/{id}")
    public Mono<Driver> getInfo(@PathVariable("id") int id){return driverService.get(id);}

    @PostMapping("")
    public Mono<Driver> create(@RequestBody Driver driver){return driverService.create(driver);}

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable("id") int id){
        return driverService.delete(id);
    }
}