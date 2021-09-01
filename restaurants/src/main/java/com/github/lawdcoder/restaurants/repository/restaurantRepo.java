package com.github.lawdcoder.restaurants.repository;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.SimpleStatement;
import com.github.lawdcoder.restaurants.domain.restaurant;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface restaurantRepo extends ReactiveCassandraRepository<restaurant, Integer>{
}
