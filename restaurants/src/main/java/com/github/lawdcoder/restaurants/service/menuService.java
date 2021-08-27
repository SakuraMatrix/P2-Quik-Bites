package com.github.lawdcoder.restaurants.service;
import com.github.lawdcoder.restaurants.domain.restaurant;
import com.github.lawdcoder.restaurants.repository.menuRepository;
import com.github.lawdcoder.restaurants.repository.restaurantRepo;
import com.github.lawdcoder.restaurants.domain.menu;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class menuService {

    private final menuRepository menuRepository;

    public menuService(menuRepository menuRepository){this.menuRepository = menuRepository;}

    public Flux<menu> getAll(){return menuRepository.findAll();}

    public Mono<menu> get(int id){return menuRepository.findById(id);}

    public Mono<menu> create(menu menu){return menuRepository.save(menu);}

    public void delete(menu menu){ menuRepository.delete(menu);}

    public String printData(){return "This is an error message";}
}
