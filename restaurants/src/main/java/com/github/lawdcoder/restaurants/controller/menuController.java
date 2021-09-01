package com.github.lawdcoder.restaurants.controller;
import com.github.lawdcoder.restaurants.service.menuService;

import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{menuId}")
    public Mono<menu> get(@PathVariable("menuId") int menuId){return menuService.get(menuId);}

    @PostMapping("")
    public menu create(@RequestBody menu menu){return menuService.create(menu);}

    @DeleteMapping("/delete/{menuId}")
    public void delete(@RequestBody menu menu){menuService.delete(menu);}
}


