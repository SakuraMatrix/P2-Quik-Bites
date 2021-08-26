package com.github.dmagare.customers.repository;

import com.github.dmagare.customers.domain.Customer;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends ReactiveCassandraRepository<Customer, Integer> {

}
