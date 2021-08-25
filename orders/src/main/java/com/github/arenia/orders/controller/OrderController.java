package com.github.arenia.orders.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.arenia.orders.domain.Order;

@RestController
public class OrderController {
  private final AtomicLong counter = new AtomicLong();
  

  @GetMapping("/order")
  public Order orders(@RequestParam(value="total", defaultValue = "0") String total) {
    return new Order((int)counter.getAndIncrement(), 0, 0, 0, Double.parseDouble(total), "started");
  }
}
