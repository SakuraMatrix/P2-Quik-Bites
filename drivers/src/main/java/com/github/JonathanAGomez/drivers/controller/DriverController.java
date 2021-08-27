package com.github.JonathanAGomez.drivers.controller;

import com.github.JonathanAGomez.drivers.domain.Driver;
import com.github.JonathanAGomez.drivers.service.DriverService;
import org.springframework.web.bind.annotation.*;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value ="/driver")
public class DriverController {
    private final DriverService driverService;

    public DriverController(DriverService service){this.driverService = service;}

    @GetMapping("")
    public Flux<Driver> getAll(){return driverService.getAll();}

    @GetMapping("/error")
    public String getError(){return driverService.printData();}

    @GetMapping("/info/{id}")
    public Mono<Driver> getInfo(@PathVariable("id") int id){return driverService.get(id);}

    @GetMapping("/id/{id}")
    public Integer getId(@PathVariable("id") int id){
        Driver temp = new Driver();
        driverService.getLocation(id).subscribe(value -> temp.setDriver_id(value.getDriver_id()));
        return temp.getDriver_id();
    }

    @GetMapping("/loc/{id}")
    public String getLocation(@PathVariable("id") int id){
        Driver temp = new Driver();
        driverService.getLocation(id).subscribe(value -> temp.setLocation(value.getLocation()));
        return temp.getLocation();
    }

    @PostMapping("")
    public Mono<Driver> create(@RequestBody Driver driver){return driverService.create(driver);}

    @DeleteMapping("/delete/{id}")
    public Mono<Void> delete(@PathVariable("id") int id){return driverService.delete(id);}
}