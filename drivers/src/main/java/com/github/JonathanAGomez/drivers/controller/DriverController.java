package com.github.JonathanAGomez.drivers.controller;

import com.github.JonathanAGomez.drivers.domain.Driver;
import com.github.JonathanAGomez.drivers.service.DriverService;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
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

    @GetMapping("/info/{id}")
    public Mono<Driver> getInfo(@PathVariable("id") int id){return driverService.get(id);}

    /*
    //Return to this if you can figure it out
    @GetMapping("/id/{id}")
    public Integer getId(@PathVariable("id") int id){
        Driver temp = new Driver();
        Subscriber<Driver> sub = new Subscriber<Driver>() {
        Subscription subscription;
            @Override
            public void onSubscribe(Subscription sub) {
            subscription = sub;
            subscription.request(1);
            System.out.println("OnSubscribe Called");
            }

            @Override
            public void onNext(Driver driver) {
                temp.setDriver_id(driver.getDriver_id());
                temp.setDriver_name(driver.getDriver_name());
                System.out.println("OnNext Called for "+ temp.getDriver_name()+" ID: "+ temp.getDriver_id());
            }
            @Override
            public void onError(Throwable throwable) {
            }
            @Override
            public void onComplete() {
            }
        };
        driverService.get(id).subscribe(sub);
        System.out.print(temp.getDriver_name() + ": ");
        System.out.println(temp.getDriver_id());

        return temp.getDriver_id();
    }

    //Return to this if you can figure it out
    @GetMapping("/loc/{id}")
    public String getLocation(@PathVariable("id") int id){
        Driver temp = new Driver();
        driverService.getLocation(id).subscribe(value -> temp.setLocation(value.getLocation()));
        return temp.getLocation();
    }

     */

    @PostMapping("")
    public Mono<Driver> create(@RequestBody Driver driver){return driverService.create(driver);}

    @DeleteMapping("/delete/{id}")
    public Mono<Void> delete(@PathVariable("id") int id){
        return driverService.delete(id);
    }
}