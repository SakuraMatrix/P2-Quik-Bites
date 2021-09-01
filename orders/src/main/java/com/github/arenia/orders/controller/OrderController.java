package com.github.arenia.orders.controller;

import com.github.arenia.orders.domain.Order;
import com.github.arenia.orders.service.OrderService;
import com.github.arenia.orders.OrderApplication;

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

    @PostMapping("")
    public Mono<Order> create(@RequestBody Order order){
    OrderApplication.orderMap.put(order.getOrderId(), order);
    OrderApplication.orderMap.get(order.getOrderId()).setOrderStatus("Placed");
    return orderService.create(order);}

    @GetMapping("/status/Ready/{id}")
    public Mono<Order> statusReady(@PathVariable("id") int id){
    OrderApplication.orderMap.get(id).setOrderStatus("Ready");
    return orderService.create(OrderApplication.orderMap.get(id));
    }

    @GetMapping("/status/Delivered/{id}")
    public Mono<Order> statusDelivered(@PathVariable("id") int id){
    OrderApplication.orderMap.get(id).setOrderStatus("Delivered");
    return orderService.create(OrderApplication.orderMap.get(id));
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> delete(@PathVariable("id") Integer id){
    OrderApplication.orderMap.remove(id);
    return orderService.delete(id);}
}
