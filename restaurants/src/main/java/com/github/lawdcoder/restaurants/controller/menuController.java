package com.github.lawdcoder.restaurants.controller;
import com.github.lawdcoder.restaurants.service.menuService;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;
import com.github.lawdcoder.restaurants.domain.restaurant;
import com.github.lawdcoder.restaurants.domain.menu;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping(value = "/menu")
public class menuController {
    private final menuService menuService;
    public menuController(menuService service){this.menuService = service;}

    @GetMapping("")
    public Flux<menu> getAll(){return menuService.getAll();}

    @GetMapping("/error")
    public String getError(){return menuService.printData();}

    @GetMapping("/{id}")
    public Mono<menu> get(@PathVariable("id") int id){return menuService.get(id);}

    @PostMapping("")
    public Mono<menu> create(@RequestBody menu menu){return menuService.create(menu);}

    @DeleteMapping("/delete/{id}")
    public void delete(@RequestBody menu driver){menuService.delete(driver);}
}


