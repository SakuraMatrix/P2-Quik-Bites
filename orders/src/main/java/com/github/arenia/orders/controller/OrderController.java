package com.github.arenia.orders.controller;

import com.github.arenia.orders.domain.Order;
import com.github.arenia.orders.service.OrderService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("")
public class OrderController {
  private final OrderService orderService;
  
  public OrderController(OrderService service){this.orderService = service;}

    @GetMapping("")
    public Flux<Order> getAll(){return orderService.getAll();}

    @GetMapping("/error")
    public String getError(){return orderService.printData();}

    @GetMapping("/{id}")
    public Mono<Order> get(@PathVariable("id") int id){return orderService.get(id);}

    @GetMapping("/{id}/{status}")
    public Mono<Order> updateStatus(@PathVariable("id") int id, @PathVariable("status") String status){return orderService.updateStatus(id, status);}

    @PostMapping("")
    public Mono<Order> create(@RequestBody Order order){return orderService.create(order);}

    @DeleteMapping("/delete/{id}")
    public Mono<Void> delete(@PathVariable("id") Integer id){return orderService.delete(id);}
}
