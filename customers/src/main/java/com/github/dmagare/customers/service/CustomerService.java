package com.github.dmagare.customers.service;

import com.github.dmagare.customers.domain.Customer;
import com.github.dmagare.customers.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository)
    {this.customerRepository=customerRepository;}

    public Flux<Customer> getAll(){
        return customerRepository.findAll();
    }
    public Mono<Customer> get(int customerId){
        return customerRepository.findById(customerId);
    }
    public Mono<Customer> create (Customer customer){
        return customerRepository.save(customer);
    }
    public void delete(Customer customer){
        customerRepository.delete(customer);
    }
    public String printData(){
        return "Sorry, an error has occurred";
    }
}
