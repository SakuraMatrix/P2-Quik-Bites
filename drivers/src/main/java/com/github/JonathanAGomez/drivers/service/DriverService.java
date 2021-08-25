package com.github.JonathanAGomez.drivers.service;

import com.github.JonathanAGomez.drivers.domain.Driver;
import com.github.JonathanAGomez.drivers.repository.DriverRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DriverService {
    //Check this var
    private DriverRepository driverRepo;

    public DriverService(DriverRepository driverRepo){this.driverRepo = driverRepo;}


    public Flux<Driver> getAll(){return driverRepo.getAll();}

    public Mono<Driver> get(int id){return driverRepo.get(id);}

    public Driver create(Driver driver){return driverRepo.create(driver);}
}