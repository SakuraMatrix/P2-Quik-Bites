package com.github.arenia.orders;

import com.github.arenia.orders.domain.Order;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@SpringBootApplication
public class OrderApplication {
	public static HashMap<Integer, Order> orderMap = new HashMap<>();
	public static void main(String[] args) { SpringApplication.run(OrderApplication.class, args); }
}
