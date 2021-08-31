package com.github.JonathanAGomez.drivers.repository;

import com.github.JonathanAGomez.drivers.domain.Driver;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends ReactiveCassandraRepository<Driver, Integer>{

}