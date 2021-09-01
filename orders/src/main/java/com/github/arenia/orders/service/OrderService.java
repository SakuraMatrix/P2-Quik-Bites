package com.github.arenia.orders.service;

import com.github.arenia.orders.domain.Order;
import com.github.arenia.orders.repository.OrderRepository;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OrderService {
  private final OrderRepository orderRepository;

  public OrderService(OrderRepository orderRepository){this.orderRepository = orderRepository;}

  public Flux<Order> getAll(){return orderRepository.findAll();}

  public Mono<Order> get(int id){return orderRepository.findById(id);}

  public Mono<Order> create(Order order){return orderRepository.save(order);}

  public Mono<Void> delete(Integer id){ return orderRepository.findById(id).
    flatMap(orderRepository::delete);}

  public Mono<Order> updateStatus(int id, String status){
    return orderRepository.findById(id)
      .map(order -> setStatus(order, status))
      .flatMap(orderRepository::save);
  }

  public Order setStatus(Order order, String status){
    order.setOrderStatus(status);
    return order;
  }
  public String printData(){return "This is an error message";}
  
}
