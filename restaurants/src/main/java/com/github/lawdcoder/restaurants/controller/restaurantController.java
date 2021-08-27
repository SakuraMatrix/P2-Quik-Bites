package com.github.lawdcoder.restaurants.controller;

import com.github.lawdcoder.restaurants.domain.restaurant;
import org.springframework.web.bind.annotation.*;
import com.github.lawdcoder.restaurants.service.RestaurantService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/restaurant")
public class restaurantController {
    private final RestaurantService RestaurantService;

    public restaurantController(RestaurantService service){this.RestaurantService = service;}

    @GetMapping("")
    public Flux<restaurant> getAll(){return RestaurantService.getAll();}

    @GetMapping("/error")
    public String getError(){return RestaurantService.printData();}

    @GetMapping("/{restaurantId}")
    public Mono<restaurant> get(@PathVariable("restaurantId") int restaurantId){return RestaurantService.get(restaurantId);}

    @PostMapping("")
    public Mono<restaurant> create(@RequestBody restaurant restaurant){return RestaurantService.create(restaurant);}

    @DeleteMapping("/delete/{restaurantId}")
    public void delete(@RequestBody restaurant restaurant){RestaurantService.delete(restaurant);}
}


