package com.github.arenia.orders.repository;

import com.github.arenia.orders.domain.Order;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends ReactiveCassandraRepository<Order, Integer>{
  
}
