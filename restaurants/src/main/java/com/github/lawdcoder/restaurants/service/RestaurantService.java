package com.github.lawdcoder.restaurants.service;

import com.github.lawdcoder.restaurants.domain.restaurant;
import com.github.lawdcoder.restaurants.domain.restaurant;
import com.github.lawdcoder.restaurants.repository.restaurantRepo;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class RestaurantService {

    private final restaurantRepo restaurantRepo;

    public RestaurantService(restaurantRepo restaurantRepo){this.restaurantRepo = restaurantRepo;}

    public Flux<restaurant> getAll(){return restaurantRepo.findAll();}

    public Mono<restaurant> get(int restaurantId){return restaurantRepo.findById(restaurantId);}

    public Mono<restaurant> create(restaurant restaurant){return restaurantRepo.save(restaurant);}

    public void delete(restaurant restaurant){ restaurantRepo.delete(restaurant);}

    public String printData(){return "This is an error message";}

}
