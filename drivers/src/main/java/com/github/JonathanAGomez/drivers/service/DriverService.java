package com.github.JonathanAGomez.drivers.service;

import com.github.JonathanAGomez.drivers.domain.Driver;
import com.github.JonathanAGomez.drivers.repository.DriverRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DriverService {
    //Check this var because the Bean dependency for service failed
    private final DriverRepository driverRepo;

    public DriverService(DriverRepository driverRepo){this.driverRepo = driverRepo;}

    public Flux<Driver> getAll(){return driverRepo.findAll();}

    public Mono<Driver> get(int id){return driverRepo.findById(id);}

    public Mono<Driver> create(Driver driver){return driverRepo.save(driver);}

    public Mono<Driver> getLocation(int id){ return get(id);}


    public Mono<Void> delete(int id){
        return driverRepo.findById(id)
            .flatMap(driverRepo::delete);
    }

    public String printData(){return "This is an error message";}
}